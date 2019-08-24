package com.olehpodolin.spring5mvcrest.services;

import com.olehpodolin.spring5mvcrest.api.v1.mapper.VendorMapper;
import com.olehpodolin.spring5mvcrest.api.v1.model.VendorDTO;
import com.olehpodolin.spring5mvcrest.repositories.VendorRepository;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return null;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return null;
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public void deleteVendorById(Long id) {

    }
}
