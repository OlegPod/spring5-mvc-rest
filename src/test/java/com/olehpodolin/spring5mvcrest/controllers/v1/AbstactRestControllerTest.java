package com.olehpodolin.spring5mvcrest.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstactRestControllerTest {

    public static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
