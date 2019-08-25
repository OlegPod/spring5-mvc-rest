package com.olehpodolin.spring5mvcrest.controllers.v1;

import com.olehpodolin.spring5mvcrest.api.v1.model.VendorDTO;
import com.olehpodolin.spring5mvcrest.services.ResourceNotFoundException;
import com.olehpodolin.spring5mvcrest.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static com.olehpodolin.spring5mvcrest.controllers.v1.AbstactRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VendorControllerTest {

    public static final Long ID = 1L;
    public static final String NAME = "Hibernate inc";

    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
    }

    @Test
    public void testListVendors() throws Exception {

        //given
        VendorDTO vendorDTO1 = new VendorDTO();
        vendorDTO1.setName("Test1");


        VendorDTO vendorDTO2 = new VendorDTO();
        vendorDTO2.setName("Test2");


        VendorDTO vendorDTO3 = new VendorDTO();
        vendorDTO3.setName("Test3");

        List<VendorDTO> testVendors = Arrays.asList(vendorDTO1, vendorDTO2);

        when(vendorService.getAllVendors()).thenReturn(testVendors);

        //when
        mockMvc.perform(get(VendorController.BASE_URL)
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andExpect(status().isOk())
                                        .andExpect(jsonPath("$.vendors", hasSize(3)));
    }

    public void getVendorById() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);
        vendorDTO.setVendor_url(CustomerController.BASE_URL + "/1");

        when(vendorService.getVendorById(anyLong())).thenReturn(vendorDTO);

        //then
        mockMvc.perform(get(VendorController.BASE_URL + "/1")
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andExpect(status().isOk())
                                        .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    public void testCreateNewCustomer() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendorDTO.getName());
        returnDTO.setVendor_url(VendorController.BASE_URL + "/1");

        when(vendorService.createNewVendor(vendorDTO)).thenReturn(returnDTO);

        //when
        mockMvc.perform(post(VendorController.BASE_URL)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(asJsonString(vendorDTO)))
                                        .andExpect(status().isCreated())
                                        .andExpect(jsonPath("$.name", equalTo(NAME)))
                                        .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    public void testUpdateCustomer() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendorDTO.getName());
        returnDTO.setVendor_url(VendorController.BASE_URL + "/1");

        when(vendorService.saveVendorByDTO(anyLong(), vendorDTO)).thenReturn(returnDTO);

        //when
        mockMvc.perform(put(VendorController.BASE_URL + "/1")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(asJsonString(vendorDTO)))
                                        .andExpect(status().isOk())
                                        .andExpect(jsonPath("$.name", equalTo(NAME)))
                                        .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    public void testPatchVendor() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendorDTO.getName());
        returnDTO.setVendor_url(VendorController.BASE_URL + "/1");

        when(vendorService.patchVendor(anyLong(), any(VendorDTO.class))).thenReturn(returnDTO);

        //when
        mockMvc.perform(patch(VendorController.BASE_URL + "/1")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(asJsonString(vendorDTO)))
                                        .andExpect(status().isOk())
                                        .andExpect(jsonPath("$.name", equalTo(NAME)))
                                        .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    public void testDeleteVendor() throws Exception {

        mockMvc.perform(delete(CustomerController.BASE_URL + "/1")
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andExpect(status().isOk());

        verify(vendorService).deleteVendorById(anyLong());
    }

    public void testNotFoundException() throws Exception {

        when(vendorService.getVendorById(anyLong())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(VendorController.BASE_URL + "/4453")
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andExpect(status().isNotFound());
    }
}