package com.axonactive.congdoan.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountAndIdDto {


    private Integer congDoanId;

    private Long amount ;
}
