package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.CongDoanService;
import com.axonactive.congdoan.service.DanhMucThuCongDoanService;
import com.axonactive.congdoan.service.ThuCongDoanService;
import com.axonactive.congdoan.service.dto.CongDoanDto;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@ActiveProfiles("unit-test")
class ThuCongDoanServiceImplTest {
    @Autowired
    ThuCongDoanService thuCongDoanService;

    @Autowired
    DanhMucThuCongDoanService danhMucThuCongDoanService;

    @Autowired
    CongDoanService congDoanService;

    @BeforeEach
    void thuCongDoanSetUp() {
        CongDoanRequest congDoan1 = CongDoanRequest.builder()
                .name("TrungUong")
                .address("2/TU")
                .district("D6")
                .city("TP.Ho Chi Minh")
                .paymentDueDate("2022-08-01")
                .paymentSentDate("2022-09-01")
                .build();
        congDoanService.save(congDoan1);

        CongDoanRequest congDoan2 = CongDoanRequest.builder()
                .name("RachMieu")
                .address("115/RM")
                .district("D1")
                .city("TP.Ho Chi Minh")
                .paymentDueDate("2022-09-01")
                .paymentSentDate("2022-10-01")
                .build();
        congDoanService.save(congDoan2);


        DanhMucThuCongDoanRequest danhMuc1 = DanhMucThuCongDoanRequest.builder()
                .code(113)
                .name("Sua Chua")
                .build();
        danhMucThuCongDoanService.save(danhMuc1);

        ThuCongDoanRequest thuCongDoan1 = ThuCongDoanRequest.builder()
                .amount(50000)
                .collectDate(LocalDate.parse("2022-09-10"))
                .congDoanId(1)
                .danhMucThuCongDoanId(1)
                .retrieveMonth(8)
                .note("Checked")
                .retrieveYear(2022)
                .build();
        thuCongDoanService.save(thuCongDoan1);

        ThuCongDoanRequest thuCongDoan2 = ThuCongDoanRequest.builder()
                .amount(90000)
                .collectDate(LocalDate.parse("2022-08-25"))
                .congDoanId(2)
                .danhMucThuCongDoanId(1)
                .retrieveMonth(8)
                .note("Checked")
                .retrieveYear(2022)
                .build();
        thuCongDoanService.save(thuCongDoan2);
    }

    @Test
    void getAll_shouldReturnListOf2ThuCongDoan_whenFound() {
        assertEquals(2,thuCongDoanService.getAll().size());
    }

    @Test
    void findById_shouldReturnThuCongDoanId2Amount_whenFound() {assertEquals(90000,thuCongDoanService.findById(2L).getAmount());
    }

    @Test
    void save_shouldReturnListOf3ThuCongDoan_whenFound() {
        DanhMucThuCongDoanRequest danhMuc2 = DanhMucThuCongDoanRequest.builder()
                .code(211)
                .name("Nang cap")
                .build();
        danhMucThuCongDoanService.save(danhMuc2);

        ThuCongDoanRequest thuCongDoan3 = ThuCongDoanRequest.builder()
                .amount(100000)
                .collectDate(LocalDate.parse("2022-08-25"))
                .congDoanId(1)
                .danhMucThuCongDoanId(2)
                .retrieveMonth(8)
                .note("Checked")
                .retrieveYear(2022)
                .build();
        thuCongDoanService.save(thuCongDoan3);

        assertEquals(3,thuCongDoanService.getAll().size());
        assertEquals(LocalDate.parse("2022-08-25"),thuCongDoanService.findById(3L).getCollectDate());
    }

    @Test
    void delete_shouldReturnListOf1ThuCongDoan_whenDelete() {
        thuCongDoanService.delete(2l);
        assertEquals(1,thuCongDoanService.getAll().size());
    }

    @Test
    void update_shouldUpdateThuCongDoanId1WithNewInformation_whenUpdate() {
        ThuCongDoanRequest thuCongDoan3 = ThuCongDoanRequest.builder()
                .amount(500000000)
                .collectDate(LocalDate.parse("2025-10-10"))
                .congDoanId(1)
                .danhMucThuCongDoanId(1)
                .retrieveMonth(10)
                .note("Checked")
                .retrieveYear(2025)
                .build();
        thuCongDoanService.save(thuCongDoan3);
        assertEquals(500000000,thuCongDoanService.update(1l,thuCongDoan3).getAmount());
        assertEquals(LocalDate.parse("2025-10-10"),thuCongDoanService.findById(1l).getCollectDate());

    }

    @Test
    void findByCongDoanId_shouldReturnAListOfThuCongDoanHaveCongDoanId1_whenFound() {
        DanhMucThuCongDoanRequest danhMuc2 = DanhMucThuCongDoanRequest.builder()
                .code(211)
                .name("Nang cap")
                .build();
        danhMucThuCongDoanService.save(danhMuc2);

        ThuCongDoanRequest thuCongDoan3 = ThuCongDoanRequest.builder()
                .amount(500000000)
                .collectDate(LocalDate.parse("2025-10-10"))
                .congDoanId(1)
                .danhMucThuCongDoanId(2)
                .retrieveMonth(10)
                .note("Checked")
                .retrieveYear(2025)
                .build();
        thuCongDoanService.save(thuCongDoan3);

        assertEquals(2,thuCongDoanService.findByCongDoanId(1).size());

    }

    @Test
    void findByMonthAndYear_shouldReturnListOfThuCongDoanWithMonthAndYear_whenFound() {
        assertEquals(2,thuCongDoanService.findByRetrieveMonthAndRetrieveYear(8,2022).size());
    }

    @Test
    void findByThuCongDoanMonthAndYear() {
        assertEquals("TrungUong",thuCongDoanService.findByThuCongDoanMonthAndYear(8,2022).get(0).getName());
        assertEquals(50000,thuCongDoanService.findByThuCongDoanMonthAndYear(8,2022).get(0).getAmount());
    }

    @Test
    void findByDateBetween() {
        assertEquals(2,thuCongDoanService.findByDateBetween(LocalDate.parse("2022-08-20"),LocalDate.parse("2022-09-11")).size());
    }
}