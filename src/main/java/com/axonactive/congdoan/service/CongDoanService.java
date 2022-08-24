package com.axonactive.congdoan.service;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.CongDoanDto;

import java.util.List;

public interface CongDoanService {
    List<CongDoanDto> getAll();

    CongDoanDto findById(Integer id) ;

    CongDoanDto save(CongDoanRequest congDoanRequest);

    void delete(Integer id) throws ResourceNotFoundException;

    CongDoanDto update(Integer id ,CongDoanRequest congDoanRequest);

    List<CongDoanDto> findByDistrictAndCityContaining (String district , String city );

    List<AmountAndIdDto> findByCongDoanIdentification (Integer id);
}
