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

    private Integer retrieveMonth;

    private Integer retrieveYear;

    private LocalDate collectDate;

    private String note;

    private Integer congDoanId;

    private Integer danhMucThuCongDoanId;
}
