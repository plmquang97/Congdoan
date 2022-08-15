package com.axonactive.congdoan.service;

import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;

import java.util.List;

public interface ThuCongDoanService {
    List<ThuCongDoanDto> getAll();

    ThuCongDoanDto findById(Long id) throws ResourceNotFoundException;

    ThuCongDoanDto save(ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException;

    void delete(Long id);

    ThuCongDoanDto update(Long id , ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException;

}
