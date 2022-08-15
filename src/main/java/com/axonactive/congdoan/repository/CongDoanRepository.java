package com.axonactive.congdoan.repository;

import com.axonactive.congdoan.entity.CongDoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongDoanRepository extends JpaRepository<CongDoan,Integer> {
}
