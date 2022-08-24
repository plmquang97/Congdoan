package com.axonactive.congdoan.service.implement;

import com.axonactive.congdoan.entity.DanhMucThuCongDoan;
import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.service.DanhMucThuCongDoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@ActiveProfiles("unit-test")
class DanhMucThuCongDoanServiceImplTest {
    @Autowired
    DanhMucThuCongDoanService danhMucThuCongDoanService;
    @BeforeEach
    void danhMucThuCongDoanSetUp(){
        DanhMucThuCongDoanRequest danhMuc1 = DanhMucThuCongDoanRequest.builder()
                .code(113)
                .name("Sua Chua")
                .build();
        danhMucThuCongDoanService.save(danhMuc1);
        DanhMucThuCongDoanRequest danhMuc2 = DanhMucThuCongDoanRequest.builder()
                .code(114)
                .name("Bao Tri")
                .build();
        danhMucThuCongDoanService.save(danhMuc2);
        DanhMucThuCongDoanRequest danhMuc3 = DanhMucThuCongDoanRequest.builder()
                .code(115)
                .name("Le Hoi")
                .build();
        danhMucThuCongDoanService.save(danhMuc3);

    }

    @Test
    void getAll_shouldGetListOf3DanhMucThu_whenFound() {
        assertEquals(3,danhMucThuCongDoanService.getAll().size());
    }

    @Test
    void findById_shouldGetNameOfDanhMucId3_whenInputId3() {
        assertEquals("Le Hoi",danhMucThuCongDoanService.findById(3).getName());
    }

    @Test
    void save_shouldGetListOf4DanhMuc_whenFound() {
        DanhMucThuCongDoanRequest danhMuc4 = DanhMucThuCongDoanRequest.builder()
                .code(116)
                .name("Van Chuyen")
                .build();
        danhMucThuCongDoanService.save(danhMuc4);
        assertEquals(4,danhMucThuCongDoanService.getAll().size());
        assertEquals("Van Chuyen",danhMucThuCongDoanService.findById(4).getName());
    }

    @Test
    void delete_shouldReturnListOf1DanhMuc_whenDelete2DanhMuc() {
        danhMucThuCongDoanService.delete(1);
        danhMucThuCongDoanService.delete(2);
        assertEquals(1,danhMucThuCongDoanService.getAll().size());
    }

    @Test
    void update_shouldReplaceDanhMucId1WithNewName_whenUpdated() {
        DanhMucThuCongDoanRequest danhMuc5 = DanhMucThuCongDoanRequest.builder()
                .code(11111)
                .name("Tiep Te")
                .build();
        assertEquals("Tiep Te",danhMucThuCongDoanService.update(1,danhMuc5).getName());
    }
}