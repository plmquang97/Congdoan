package com.axonactive.congdoan.resource;

import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.ThuCongDoanService;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(ThuCongDoanResource.PATH)
public class ThuCongDoanResource {
    public static final String PATH = "/api/thucongdoans";

    @Autowired
    ThuCongDoanService thuCongDoanService;

    @GetMapping
    ResponseEntity<List<ThuCongDoanDto>> findAll() {
        return ResponseEntity.ok(thuCongDoanService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ThuCongDoanDto> findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(thuCongDoanService.findById(id));
    }

    @PostMapping
    ResponseEntity<ThuCongDoanDto> add(@RequestBody ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException {
        ThuCongDoanDto createdThuCongDoan = thuCongDoanService.save(thuCongDoanRequest);
        return ResponseEntity
                .created(URI.create(ThuCongDoanResource.PATH + "/" + createdThuCongDoan.getId()))
                .body(createdThuCongDoan);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        thuCongDoanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<ThuCongDoanDto> update(@PathVariable(value = "id") Long id, @RequestBody ThuCongDoanRequest thuCongDoanRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(thuCongDoanService.update(id, thuCongDoanRequest));
    }
}
