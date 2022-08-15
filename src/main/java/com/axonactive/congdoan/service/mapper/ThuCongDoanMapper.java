package com.axonactive.congdoan.service.mapper;

import com.axonactive.congdoan.entity.ThuCongDoan;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface ThuCongDoanMapper {
    ThuCongDoanDto toDto(ThuCongDoan thuCongDoan);

    List<ThuCongDoanDto> toDtos(List<ThuCongDoan> thuCongDoans);
}
