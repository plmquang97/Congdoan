package com.axonactive.congdoan.repository;

import com.axonactive.congdoan.entity.ThuCongDoan;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.AmountWithIdAndNameOfCongDoanDto;
import com.axonactive.congdoan.service.dto.DateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ThuCongDoanRepository extends JpaRepository<ThuCongDoan,Long> {
    List<ThuCongDoan> findByCongDoanId (Integer id);

    List<ThuCongDoan> findByMonthAndYear (Integer month , Integer year);

    @Query("SELECT new com.axonactive.congdoan.service.dto.AmountAndIdDto (t.congDoan.id ,  SUM(t.amount)) " +
            "FROM ThuCongDoan t  " +
            "WHERE t.congDoan.id = ?1 " +
            "GROUP BY t.congDoan.id")
    List<AmountAndIdDto> findByCongDoanIdentification (Integer id);

    @Query("SELECT new com.axonactive.congdoan.service.dto.AmountWithIdAndNameOfCongDoanDto ( cd.id , cd.name , SUM(t.amount)) " +
            "FROM CongDoan cd LEFT JOIN ThuCongDoan t " +
            "ON cd.id = t.congDoan.id " +
                "AND t.month = ?1 " +
                "AND t.year = ?2 " +
            "GROUP BY cd.id ,cd.name")
    List<AmountWithIdAndNameOfCongDoanDto> findByThuCongDoanMonthAndYear (Integer month , Integer year );

    @Query("SELECT new com.axonactive.congdoan.service.dto.DateDto (cd.id , cd.name , t.collectDate , Sum(t.amount)) "+
            "FROM ThuCongDoan t JOIN CongDoan cd " +
            "ON cd.id = t.congDoan.id " +
                "AND t.collectDate >= ?1 " +
                "AND t.collectDate <= ?2 " +
            "GROUP BY cd.id , cd.name , t.collectDate")
    List<DateDto> findByDateBetween (LocalDate fromDate , LocalDate toDate);
}
