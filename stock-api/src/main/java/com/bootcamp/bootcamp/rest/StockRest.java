package com.bootcamp.bootcamp.rest;

import com.bootcamp.bootcamp.model.dto.StockDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/stock")
public class StockRest {
    @PostMapping
    public ResponseEntity<StockDto> save(@RequestBody StockDto stock) {
        return ResponseEntity.ok(stock);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<StockDto> update() {
        return ResponseEntity.ok(new StockDto());
    }
    @GetMapping
    public ResponseEntity<List<StockDto>> findAll() {
        ArrayList lista = new ArrayList();
        lista.add(new StockDto());
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<StockDto> findById(@PathVariable int id) {
        return ResponseEntity.ok(new StockDto());
    }
}
