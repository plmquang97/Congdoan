package com.axonactive.congdoan.resource;


import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.DanhMucThuCongDoanRequest;
import com.axonactive.congdoan.service.DanhMucThuCongDoanService;
import com.axonactive.congdoan.service.dto.DanhMucThuCongDoanDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(DanhMucThuCongDoanResource.PATH)
public class DanhMucThuCongDoanResource {
    public static final String PATH = "/api/danhmucthucongdoans";

    @Autowired
    DanhMucThuCongDoanService danhMucThuCongDoanService;

    @GetMapping
    ResponseEntity<List<DanhMucThuCongDoanDto>> findAll() {
        return ResponseEntity.ok(danhMucThuCongDoanService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<DanhMucThuCongDoanDto> findById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(danhMucThuCongDoanService.findById(id));
    }

    @PostMapping
    ResponseEntity<DanhMucThuCongDoanDto> add(@RequestBody DanhMucThuCongDoanRequest danhMucThuCongDoanRequest) {
        DanhMucThuCongDoanDto createdDanhMucThuCongDoan = danhMucThuCongDoanService.save(danhMucThuCongDoanRequest);
        return ResponseEntity
                .created(URI.create(DanhMucThuCongDoanResource.PATH + "/" + createdDanhMucThuCongDoan.getId()))
                .body(createdDanhMucThuCongDoan);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        danhMucThuCongDoanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<DanhMucThuCongDoanDto> update(@PathVariable(value = "id") Integer id, @RequestBody DanhMucThuCongDoanRequest danhMucThuCongDoanRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(danhMucThuCongDoanService.update(id, danhMucThuCongDoanRequest));
    }
}
