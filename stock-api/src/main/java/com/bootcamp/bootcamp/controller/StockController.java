package com.bootcamp.bootcamp.controller;

import com.bootcamp.bootcamp.model.dto.StockDto;
import com.bootcamp.bootcamp.model.entity.Stock;
import com.bootcamp.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<StockDto> save(@Valid @RequestBody StockDto stockDto) {
        return ResponseEntity.ok(this.stockService.save(stockDto));
    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<StockDto> update(@Valid @RequestBody StockDto stockDto) {
        return ResponseEntity.ok(this.stockService.update(stockDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.stockService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}")
    public ResponseEntity<StockDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.stockService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<StockDto>> findAll() {
        return ResponseEntity.ok(this.stockService.findAll());
    }
    @GetMapping("today")
    public ResponseEntity<List<StockDto>> findByToday() {
        return ResponseEntity.ok(this.stockService.findByToday());
    }

}
