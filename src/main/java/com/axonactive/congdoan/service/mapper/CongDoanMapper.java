package com.axonactive.congdoan.service.mapper;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.service.dto.CongDoanDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface CongDoanMapper {
    CongDoanDto toDto(CongDoan congDoan);

    List<CongDoanDto> toDtos(List<CongDoan> congDoans);
}
