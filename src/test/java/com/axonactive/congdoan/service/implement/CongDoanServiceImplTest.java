package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.entity.ThuCongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.repository.ThuCongDoanRepository;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.CongDoanService;
import com.axonactive.congdoan.service.DanhMucThuCongDoanService;
import com.axonactive.congdoan.service.ThuCongDoanService;
import com.axonactive.congdoan.service.dto.CongDoanDto;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;
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
class CongDoanServiceImplTest {

    @Autowired
    CongDoanService congDoanService;

    @Autowired
    DanhMucThuCongDoanService danhMucThuCongDoanService;

    @Autowired
    ThuCongDoanService thuCongDoanService;

    @BeforeEach
    void congDoanSetUp() {
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

    }

    @Test
    void getAll_shouldReturnListOf2CongDoan_whenFound() {
        assertEquals(2, congDoanService.getAll().size());
    }

    @Test
    void findById_shouldReturnCongDoanNameTrungUong_whenInputId1() {
        assertEquals("TrungUong", congDoanService.findById(1).getName());
    }

    @Test
    void save_shouldReturnListOf3CongDoan_whenFound() {
        CongDoanRequest congDoan3 = new CongDoanRequest();
        congDoan3.setName("PhamVanChi");
        congDoan3.setAddress("11/PVC");
        congDoan3.setDistrict("Q6");
        congDoan3.setCity("TP.Ho Chi Minh");
        congDoan3.setPaymentSentDate("2022-08-10");
        congDoan3.setPaymentDueDate("2022-09-10");
        congDoanService.save(congDoan3);
        assertEquals(3, congDoanService.getAll().size());
        assertEquals("PhamVanChi", congDoanService.findById(3).getName());

    }

    @Test
    void delete_shouldReturn1CongDoan_whenDelete1() {
        congDoanService.delete(1);
        assertEquals(1, congDoanService.getAll().size());
    }

    @Test
    void update_shouldReturnCongDoanWithNewUpdatedInfo_whenUpdateCongDoanId1() {
        CongDoanRequest congDoan3 = new CongDoanRequest();
        congDoan3.setName("PhamVanChi");
        congDoan3.setAddress("11/PVC");
        congDoan3.setDistrict("Q6");
        congDoan3.setCity("TP.Ho Chi Minh");
        congDoan3.setPaymentSentDate("2022-08-10");
        congDoan3.setPaymentDueDate("2022-09-10");
        assertEquals("PhamVanChi", congDoanService.update(1, congDoan3).getName());
    }

    @Test
    void findByDistrictAndCityContaining_shouldReturn1CongDoanWithAccurateDistrictAndCity_whenInputDistrictAndCity() {
        assertEquals(1, congDoanService.findByDistrictAndCityContaining("D6", "TP.Ho Chi Minh").size());
    }

    @Test
    void findByCongDoanIdentification_shouldReturnTotalAmountOfCongDoan_whenInputId1() {

        DanhMucThuCongDoanRequest danhMuc1 = DanhMucThuCongDoanRequest.builder()
                .code(1)
                .name("Dien Tap")
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

        assertEquals(50000, congDoanService.findByCongDoanIdentification(1).get(0).getAmount());
    }
}