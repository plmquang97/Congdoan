package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.repository.CongDoanRepository;
import com.axonactive.congdoan.repository.ThuCongDoanRepository;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.service.CongDoanService;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.CongDoanDto;
import com.axonactive.congdoan.service.mapper.CongDoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CongDoanServiceImpl implements CongDoanService {
    @Autowired
    CongDoanRepository congDoanRepository;

    @Autowired
    ThuCongDoanRepository thuCongDoanRepository;

    @Autowired
    CongDoanMapper congDoanMapper;

    @Override
    public List<CongDoanDto> getAll() {
        return congDoanMapper.toDtos(congDoanRepository.findAll());
    }

    @Override
    public CongDoanDto findById(Integer id) throws ResourceNotFoundException {
        return congDoanMapper.toDto(congDoanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cong doan Id not found")));
    }

    @Override
    public CongDoanDto save(CongDoanRequest congDoanRequest) {
        CongDoan createdCongDoan = new CongDoan();
        createdCongDoan.setName(congDoanRequest.getName());
        createdCongDoan.setAddress(congDoanRequest.getAddress());
        createdCongDoan.setDistrict(congDoanRequest.getDistrict());
        createdCongDoan.setCity(congDoanRequest.getCity());
        createdCongDoan.setPaymentDueDate(congDoanRequest.getPaymentDueDate());
        createdCongDoan.setPaymentSentDate(congDoanRequest.getPaymentSentDate());
        return congDoanMapper.toDto(congDoanRepository.save(createdCongDoan));
    }

    @Override
    public void delete(Integer id) {
        congDoanRepository.deleteById(id);
    }

    @Override
    public CongDoanDto update(Integer id, CongDoanRequest congDoanRequest) throws ResourceNotFoundException {
        CongDoan updatedCongDoan = congDoanRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cong Doan Id not found"));
        updatedCongDoan.setName((congDoanRequest.getName()));
        updatedCongDoan.setAddress(congDoanRequest.getAddress());
        updatedCongDoan.setDistrict(congDoanRequest.getDistrict());
        updatedCongDoan.setCity(congDoanRequest.getCity());
        updatedCongDoan.setPaymentDueDate(congDoanRequest.getPaymentDueDate());
        updatedCongDoan.setPaymentSentDate(congDoanRequest.getPaymentSentDate());
        return congDoanMapper.toDto(congDoanRepository.save(updatedCongDoan));
    }

    @Override
    public List<CongDoanDto> findByDistrictAndCityContaining(String district, String city) {
        return congDoanMapper.toDtos(congDoanRepository.findByDistrictAndCityContaining(district ,city));
    }

    @Override
    public List<AmountAndIdDto> findByCongDoanIdentification(Integer id) {
        return thuCongDoanRepository.findByCongDoanIdentification(id);
    }
}
