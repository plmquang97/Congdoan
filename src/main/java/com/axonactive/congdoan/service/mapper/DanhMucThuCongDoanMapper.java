package com.axonactive.congdoan.service.mapper;

import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DanhMucThuCongDoanMapper {
    DanhMucThuCongDoanDto toDto(DanhMucThuCongDoan danhMucThuCongDoan);

    List<DanhMucThuCongDoanDto> toDtos(List<DanhMucThuCongDoan> danhMucThuCongDoans);
}
