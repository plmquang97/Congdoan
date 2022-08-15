package com.axonactive.congdoan.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CongDoanDto {

    private Integer id;

    private String name;

    private String address;

    private String district;

    private String city;

    private String paymentDueDate;

    private String paymentSentDate;

}
