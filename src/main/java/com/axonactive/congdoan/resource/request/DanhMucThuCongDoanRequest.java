package com.axonactive.congdoan.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhMucThuCongDoanRequest {
    private Integer code;

    private String name;
}
