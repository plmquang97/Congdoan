package com.axonactive.congdoan.resource;

import com.axonactive.congdoan.exception.ResourceNotFoundException;
import com.axonactive.congdoan.resource.request.ThuCongDoanRequest;
import com.axonactive.congdoan.service.ThuCongDoanService;
import com.axonactive.congdoan.service.dto.AmountWithIdAndNameOfCongDoanDto;
import com.axonactive.congdoan.service.dto.DateDto;
import com.axonactive.congdoan.service.dto.ThuCongDoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
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

    @GetMapping("/GetByCongDoanId")
    ResponseEntity<List<ThuCongDoanDto>> findByCongDoanId (@RequestParam Integer id){
        return ResponseEntity.ok(thuCongDoanService.findByCongDoanId(id));
    }

    @GetMapping("/GetByMonthAndYear")
    ResponseEntity<List<ThuCongDoanDto>> findByMonthAndYear (@RequestParam Integer month , Integer year){
        return ResponseEntity.ok(thuCongDoanService.findByMonthAndYear(month ,year));
    }
    @GetMapping("/GetEveryCongDoanByMonthAndYear")
    ResponseEntity<List<AmountWithIdAndNameOfCongDoanDto>> findCongDoanByMonthAndYear (@RequestParam Integer month , Integer year){
        return ResponseEntity.ok(thuCongDoanService.findByThuCongDoanMonthAndYear(month , year));
    }

    @GetMapping("/GetCongDoanAmountBetweenDate")
    ResponseEntity<List<DateDto>> findCongDoanAmountBetweenDate (@RequestParam (value = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate fromDate , @RequestParam (value = "toDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate){
        return ResponseEntity.ok(thuCongDoanService.findByDateBetween(fromDate , toDate));
    }
}
