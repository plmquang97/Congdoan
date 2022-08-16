package com.axonactive.congdoan.resource;

import com.axonactive.congdoan.entity.CongDoan;
import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.CongDoanRequest;
import com.axonactive.congdoan.service.CongDoanService;
import com.axonactive.congdoan.service.dto.AmountAndIdDto;
import com.axonactive.congdoan.service.dto.CongDoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(CongDoanResource.PATH)
public class CongDoanResource {
    public static final String PATH = "/api/congdoans";

    @Autowired
    CongDoanService congDoanService;

    @GetMapping
    ResponseEntity<List<CongDoanDto>> findAll() {
        return ResponseEntity.ok(congDoanService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<CongDoanDto> findById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(congDoanService.findById(id));
    }

    @PostMapping()
    ResponseEntity<CongDoanDto> add(@RequestBody CongDoanRequest congDoanRequest) {
        CongDoanDto createdCongDoan = congDoanService.save(congDoanRequest);
        return ResponseEntity
                .created(URI.create(CongDoanResource.PATH + "/" + createdCongDoan.getId()))
                .body(createdCongDoan);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        congDoanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<CongDoanDto> update(@PathVariable(value = "id") Integer id, @RequestBody CongDoanRequest congDoanRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(congDoanService.update(id, congDoanRequest));
    }

    @GetMapping("/GetByDistrictAndCity")
    ResponseEntity<List<CongDoanDto>> findCongDoanByDistrictAndCity(@RequestParam String district ,String city){
        return ResponseEntity.ok(congDoanService.findByDistrictAndCityContaining(district,city));
    }

    @GetMapping("/GetTotalAmount")
    ResponseEntity<List<AmountAndIdDto>> findSumAmountByCongDoanId(@RequestParam Integer id){
        return ResponseEntity.ok(congDoanService.findByCongDoanIdentification(id));
    }
}
