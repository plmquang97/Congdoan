package com.axonactive.congdoan.resource.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DanhMucThuCongDoanRequest {
    private Integer code;

    private String name;
}
