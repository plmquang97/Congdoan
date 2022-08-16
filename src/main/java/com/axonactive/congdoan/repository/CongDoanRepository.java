package com.axonactive.congdoan.repository;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.service.dto.CongDoanDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongDoanRepository extends JpaRepository<CongDoan,Integer> {
    List<CongDoan> findByDistrictAndCityContaining (String district , String city );
}
