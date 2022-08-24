package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.entity.ThuCongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.repository.CongDoanRepository;
import com.axonactive.congdoan.repository.DanhMucThuCongDoanRepository;
import com.axonactive.congdoan.repository.ThuCongDoanRepository;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.ThuCongDoanService;
import com.axonactive.congdoan.service.dto.AmountWithIdAndNameOfCongDoanDto;
import com.axonactive.congdoan.service.dto.DateDto;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;
import com.axonactive.congdoan.service.mapper.ThuCongDoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ThuCongDoanServiceImpl implements ThuCongDoanService {
    @Autowired
    ThuCongDoanMapper thuCongDoanMapper;
    @Autowired
    ThuCongDoanRepository thuCongDoanRepository;

    @Autowired
    CongDoanRepository congDoanRepository;

    @Autowired
    DanhMucThuCongDoanRepository danhMucThuCongDoanRepository;

    @Override
    public List<ThuCongDoanDto> getAll() {
        return thuCongDoanMapper.toDtos(thuCongDoanRepository.findAll());
    }

    @Override
    public ThuCongDoanDto findById(Long id) {
        return thuCongDoanMapper.toDto(thuCongDoanRepository.findById(id).orElseThrow(ResourceNotFoundException::ThuCongDoanNotFound));
    }

    @Override
    public ThuCongDoanDto save(ThuCongDoanRequest thuCongDoanRequest) {
        ThuCongDoan createdThuCongDoan = new ThuCongDoan();
        createdThuCongDoan.setAmount(thuCongDoanRequest.getAmount());
        createdThuCongDoan.setRetrieveMonth(thuCongDoanRequest.getRetrieveMonth());
        createdThuCongDoan.setRetrieveYear(thuCongDoanRequest.getRetrieveYear());
        createdThuCongDoan.setCollectDate(thuCongDoanRequest.getCollectDate());
        createdThuCongDoan.setNote(thuCongDoanRequest.getNote());
        CongDoan congDoan = congDoanRepository.findById(thuCongDoanRequest.getCongDoanId()).orElseThrow(ResourceNotFoundException::CongDoanNotFound);
        DanhMucThuCongDoan danhMucThuCongDoan = danhMucThuCongDoanRepository.findById(thuCongDoanRequest.getDanhMucThuCongDoanId()).orElseThrow(ResourceNotFoundException::DanhMucThuCongDoanNotFound);
        createdThuCongDoan.setCongDoan(congDoan);
        createdThuCongDoan.setDanhMucThuCongDoan(danhMucThuCongDoan);
        return thuCongDoanMapper.toDto(thuCongDoanRepository.save(createdThuCongDoan));
    }

    @Override
    public void delete(Long id) {
        thuCongDoanRepository.findById(id).orElseThrow(ResourceNotFoundException::ThuCongDoanNotFound);
        thuCongDoanRepository.deleteById(id);

    }

    @Override
    public ThuCongDoanDto update(Long id, ThuCongDoanRequest thuCongDoanRequest) {
        ThuCongDoan updatedThuCongDoan = thuCongDoanRepository.findById(id).orElseThrow(ResourceNotFoundException::ThuCongDoanNotFound);
        updatedThuCongDoan.setAmount(thuCongDoanRequest.getAmount());
        updatedThuCongDoan.setRetrieveMonth(thuCongDoanRequest.getRetrieveMonth());
        updatedThuCongDoan.setRetrieveYear(thuCongDoanRequest.getRetrieveYear());
        updatedThuCongDoan.setCollectDate(thuCongDoanRequest.getCollectDate());
        updatedThuCongDoan.setNote(thuCongDoanRequest.getNote());
        CongDoan congDoan = congDoanRepository.findById(thuCongDoanRequest.getCongDoanId()).orElseThrow(ResourceNotFoundException::CongDoanNotFound);
        DanhMucThuCongDoan danhMucThuCongDoan = danhMucThuCongDoanRepository.findById(thuCongDoanRequest.getDanhMucThuCongDoanId()).orElseThrow(ResourceNotFoundException::DanhMucThuCongDoanNotFound);
        updatedThuCongDoan.setCongDoan(congDoan);
        updatedThuCongDoan.setDanhMucThuCongDoan(danhMucThuCongDoan);
        return thuCongDoanMapper.toDto(thuCongDoanRepository.save(updatedThuCongDoan));
    }

    @Override
    public List<ThuCongDoanDto> findByCongDoanId(Integer id) {
        return thuCongDoanMapper.toDtos(thuCongDoanRepository.findByCongDoanId(id));
    }

    @Override
    public List<ThuCongDoanDto> findByRetrieveMonthAndRetrieveYear(Integer month, Integer year) {
        return thuCongDoanMapper.toDtos(thuCongDoanRepository.findByRetrieveMonthAndRetrieveYear(month ,year));
    }

    @Override
    public List<AmountWithIdAndNameOfCongDoanDto> findByThuCongDoanMonthAndYear(Integer month, Integer year) {
        return thuCongDoanRepository.findByThuCongDoanMonthAndYear(month,year);
    }

    @Override
    public List<DateDto> findByDateBetween(LocalDate fromDate, LocalDate toDate) {
        return thuCongDoanRepository.findByDateBetween(fromDate, toDate);
    }

}
