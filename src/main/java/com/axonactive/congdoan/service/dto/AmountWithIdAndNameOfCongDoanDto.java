package com.axonactive.congdoan.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountWithIdAndNameOfCongDoanDto {
    private Integer congDoanId;

    private String name;

    private Long amount;
}
