package com.olehpodolin.spring5mvcrest.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @ApiModelProperty(value = "First Name of the Customer", required = true)
    private String firstname;

    @ApiModelProperty(required = true)
    private String lastname;

    private String customer_url;
}
