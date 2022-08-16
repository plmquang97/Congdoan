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
    public ThuCongDoanDto findById(Long id) throws ResourceNotFoundException {
        return thuCongDoanMapper.toDto(thuCongDoanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Thu Cong Doan Id not found ")));
    }

    @Override
    public ThuCongDoanDto save(ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException {
        ThuCongDoan createdThuCongDoan = new ThuCongDoan();
        createdThuCongDoan.setAmount(thuCongDoanRequest.getAmount());
        createdThuCongDoan.setMonth(thuCongDoanRequest.getMonth());
        createdThuCongDoan.setYear(thuCongDoanRequest.getYear());
        createdThuCongDoan.setCollectDate(thuCongDoanRequest.getCollectDate());
        createdThuCongDoan.setNote(thuCongDoanRequest.getNote());
        CongDoan congDoan = congDoanRepository.findById(thuCongDoanRequest.getCongDoanId()).orElseThrow(()-> new ResourceNotFoundException("Cong Doan Id Not Found"));
        DanhMucThuCongDoan danhMucThuCongDoan = danhMucThuCongDoanRepository.findById(thuCongDoanRequest.getDanhMucThuCongDoanId()).orElseThrow(()-> new ResourceNotFoundException("Danh Muc Thu Cong Doan Id Not Found"));
        createdThuCongDoan.setCongDoan(congDoan);
        createdThuCongDoan.setDanhMucThuCongDoan(danhMucThuCongDoan);
        return thuCongDoanMapper.toDto(thuCongDoanRepository.save(createdThuCongDoan));
    }

    @Override
    public void delete(Long id) {
        thuCongDoanRepository.deleteById(id);
    }

    @Override
    public ThuCongDoanDto update(Long id, ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException {
        ThuCongDoan updatedThuCongDoan = thuCongDoanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Thu Cong Doan Id Not Found "));
        updatedThuCongDoan.setAmount(thuCongDoanRequest.getAmount());
        updatedThuCongDoan.setMonth(thuCongDoanRequest.getMonth());
        updatedThuCongDoan.setYear(thuCongDoanRequest.getYear());
        updatedThuCongDoan.setCollectDate(thuCongDoanRequest.getCollectDate());
        updatedThuCongDoan.setNote(thuCongDoanRequest.getNote());
        CongDoan congDoan = congDoanRepository.findById(thuCongDoanRequest.getCongDoanId()).orElseThrow(()-> new ResourceNotFoundException("Cong Doan Id Not Found"));
        DanhMucThuCongDoan danhMucThuCongDoan = danhMucThuCongDoanRepository.findById(thuCongDoanRequest.getDanhMucThuCongDoanId()).orElseThrow(()-> new ResourceNotFoundException("Danh Muc Thu Cong Doan Id Not Found"));
        updatedThuCongDoan.setCongDoan(congDoan);
        updatedThuCongDoan.setDanhMucThuCongDoan(danhMucThuCongDoan);
        return thuCongDoanMapper.toDto(thuCongDoanRepository.save(updatedThuCongDoan));
    }

    @Override
    public List<ThuCongDoanDto> findByCongDoanId(Integer id) {
        return thuCongDoanMapper.toDtos(thuCongDoanRepository.findByCongDoanId(id));
    }

    @Override
    public List<ThuCongDoanDto> findByMonthAndYear(Integer month, Integer year) {
        return thuCongDoanMapper.toDtos(thuCongDoanRepository.findByMonthAndYear(month ,year));
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
