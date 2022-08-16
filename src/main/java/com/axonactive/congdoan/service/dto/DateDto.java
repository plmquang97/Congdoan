package com.axonactive.congdoan.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateDto {
    private Integer congDoanId;

    private String name;

    private LocalDate collectDate;

    private Long amount;
}
