package com.olehpodolin.spring5mvcrest.services;

import com.olehpodolin.spring5mvcrest.api.v1.mapper.VendorMapper;
import com.olehpodolin.spring5mvcrest.api.v1.model.VendorDTO;
import com.olehpodolin.spring5mvcrest.controllers.v1.VendorController;
import com.olehpodolin.spring5mvcrest.domain.Vendor;
import com.olehpodolin.spring5mvcrest.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendor_url(getVendorUrl(vendor.getId()));
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {

        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .map(vendorDTO -> {
                    vendorDTO.setVendor_url(getVendorUrl(id));
                    return vendorDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {

        return saveAndReturnDTO(vendorMapper.vendorDTOToVendor(vendorDTO));

    }

    private VendorDTO saveAndReturnDTO(Vendor vendor) {

        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(savedVendor);

        returnDTO.setVendor_url(getVendorUrl(savedVendor.getId()));

        return returnDTO;
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);

        return saveAndReturnDTO(vendor);

    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {

        return vendorRepository.findById(id).map(vendor -> {

            if (vendorDTO.getName() != null) {
                vendor.setName(vendorDTO.getName());
            }

            VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));

            returnDTO.setVendor_url(getVendorUrl(id));

            return returnDTO;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }

    private String getVendorUrl(Long id) {
        return VendorController.BASE_URL + "/" + id;
    }
}
