package com.axonactive.congdoan.resource.request;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThuCongDoanRequest {
    private Integer amount;

    private Integer retrieveMonth;

    private Integer retrieveYear;

    private LocalDate collectDate;

    private String note;

    private Integer congDoanId;

    private Integer danhMucThuCongDoanId;



}
