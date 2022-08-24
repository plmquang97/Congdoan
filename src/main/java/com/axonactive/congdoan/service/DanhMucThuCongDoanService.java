package com.axonactive.congdoan.service;


import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;

import java.util.List;

public interface DanhMucThuCongDoanService {
    List<DanhMucThuCongDoanDto> getAll();

    DanhMucThuCongDoanDto findById(Integer id) ;

    DanhMucThuCongDoanDto save(DanhMucThuCongDoanRequest danhMucThuCongDoanRequest);

    void delete(Integer id);

    DanhMucThuCongDoanDto update(Integer id , DanhMucThuCongDoanRequest danhMucThuCongDoanRequest);

}
