package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.repository.DanhMucThuCongDoanRepository;
import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.service.DanhMucThuCongDoanService;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;
import com.axonactive.congdoan.service.mapper.DanhMucThuCongDoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DanhMucThuCongDoanServiceImpl  implements DanhMucThuCongDoanService {
    @Autowired
    DanhMucThuCongDoanMapper danhMucThuCongDoanMapper;
    @Autowired
    DanhMucThuCongDoanRepository danhMucThuCongDoanRepository;

    @Override
    public List<DanhMucThuCongDoanDto> getAll() {
        return danhMucThuCongDoanMapper.toDtos(danhMucThuCongDoanRepository.findAll()) ;
    }

    @Override
    public DanhMucThuCongDoanDto findById(Integer id) throws ResourceNotFoundException {
        return danhMucThuCongDoanMapper.toDto(danhMucThuCongDoanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Danh Muc Thu Cong Doan Id Not Found")));
    }

    @Override
    public DanhMucThuCongDoanDto save(DanhMucThuCongDoanRequest danhMucThuCongDoanRequest) {
        DanhMucThuCongDoan createdDanhMucThuCongDoan = new DanhMucThuCongDoan();
        createdDanhMucThuCongDoan.setCode(danhMucThuCongDoanRequest.getCode());
        createdDanhMucThuCongDoan.setName(danhMucThuCongDoanRequest.getName());
        return danhMucThuCongDoanMapper.toDto(danhMucThuCongDoanRepository.save(createdDanhMucThuCongDoan));
    }

    @Override
    public void delete(Integer id) {
        danhMucThuCongDoanRepository.deleteById(id);
    }

    @Override
    public DanhMucThuCongDoanDto update(Integer id, DanhMucThuCongDoanRequest danhMucThuCongDoanRequest) throws ResourceNotFoundException {
        DanhMucThuCongDoan updatedDanhMucThuCongDoan = danhMucThuCongDoanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Danh Muc Thu Cong Doan Id Not Found"));
        updatedDanhMucThuCongDoan.setName(danhMucThuCongDoanRequest.getName());
        updatedDanhMucThuCongDoan.setCode(danhMucThuCongDoanRequest.getCode());
        return danhMucThuCongDoanMapper.toDto(danhMucThuCongDoanRepository.save(updatedDanhMucThuCongDoan));
    }
}
