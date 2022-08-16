package com.axonactive.congdoan.service;

import com.axonactive.congdoan.entity.ThuCongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.AmountWithIdAndNameOfCongDoanDto;
import com.axonactive.congdoan.service.dto.DateDto;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;

import java.time.LocalDate;
import java.util.List;

public interface ThuCongDoanService {
    List<ThuCongDoanDto> getAll();

    ThuCongDoanDto findById(Long id) throws ResourceNotFoundException;

    ThuCongDoanDto save(ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException;

    void delete(Long id);

    ThuCongDoanDto update(Long id , ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException;

    List<ThuCongDoanDto> findByCongDoanId (Integer id);

    List<ThuCongDoanDto> findByMonthAndYear (Integer month , Integer year);

    List<AmountWithIdAndNameOfCongDoanDto> findByThuCongDoanMonthAndYear (Integer month , Integer year );

    List<DateDto> findByDateBetween (LocalDate fromDate , LocalDate toDate);

}
