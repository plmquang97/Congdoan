package com.axonactive.congdoan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThuCongDoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    private Integer retrieveMonth;

    private Integer retrieveYear;

    private LocalDate collectDate;

    private String note;

    @JoinColumn
    @ManyToOne
    private CongDoan congDoan;

    @JoinColumn
    @ManyToOne
    private  DanhMucThuCongDoan danhMucThuCongDoan;
}
