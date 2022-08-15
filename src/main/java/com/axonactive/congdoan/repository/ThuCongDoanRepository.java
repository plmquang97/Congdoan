package com.axonactive.congdoan.repository;

import com.axonactive.congdoan.entity.ThuCongDoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuCongDoanRepository extends JpaRepository<ThuCongDoan,Long> {
}
