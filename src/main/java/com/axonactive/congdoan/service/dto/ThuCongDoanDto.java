package com.axonactive.congdoan.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThuCongDoanDto {
    private Long id;

    private Integer amount;

    private Integer month;

    private Integer year;

    private LocalDate collectDate;

    private String note;
}
