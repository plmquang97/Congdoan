package com.axonactive.congdoan.repository;

import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucThuCongDoanRepository extends JpaRepository<DanhMucThuCongDoan,Integer> {
}
