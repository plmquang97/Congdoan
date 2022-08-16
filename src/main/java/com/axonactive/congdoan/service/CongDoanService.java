package com.axonactive.congdoan.service;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.CongDoanDto;

import java.util.List;

public interface CongDoanService {
    List<CongDoanDto> getAll();

    CongDoanDto findById(Integer id) throws ResourceNotFoundException;

    CongDoanDto save(CongDoanRequest congDoanRequest);

    void delete(Integer id);

    CongDoanDto update(Integer id ,CongDoanRequest congDoanRequest) throws ResourceNotFoundException;

    List<CongDoanDto> findByDistrictAndCityContaining (String district , String city );

    List<AmountAndIdDto> findByCongDoanIdentification (Integer id);
}
