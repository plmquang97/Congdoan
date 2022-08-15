package com.axonactive.congdoan.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CongDoanRequest {

    private String name;

    private String address;

    private String district;

    private String city;

    private String paymentDueDate;

    private String paymentSentDate;
}
