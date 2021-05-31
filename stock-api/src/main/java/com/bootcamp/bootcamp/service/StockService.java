package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.exceptions.BusinessException;
import com.bootcamp.bootcamp.exceptions.NotFoundException;
import com.bootcamp.bootcamp.model.dto.StockDto;
import com.bootcamp.bootcamp.model.entity.Stock;
import com.bootcamp.bootcamp.repository.StockRepository;
import com.bootcamp.bootcamp.utils.Messages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public StockDto save(StockDto stockDto) {
        Optional<Stock> stockOptional = this.stockRepository.findByNomeAndData(stockDto.getNome(),stockDto.getData());
        if(stockOptional.isPresent()) {
            throw new BusinessException(Messages.STOCK_ALREADY_EXIST);
        }
        Stock stock = this.modelMapper.map(stockDto,Stock.class);
        stockRepository.save(stock);
        return modelMapper.map(stock,StockDto.class);
    }
    @Transactional
    public StockDto update(StockDto stockDto) {
        Optional<Stock> stockOptional = this.stockRepository.findByStockUpdate(stockDto.getNome(),stockDto.getData(),stockDto.getId());
        if(stockOptional.isPresent()) {
            throw new BusinessException(Messages.STOCK_ALREADY_EXIST);
        }
        Stock stock = this.modelMapper.map(stockDto,Stock.class);
        stockRepository.save(stock);
        return modelMapper.map(stock,StockDto.class);
    }
    @Transactional
    public void delete(Long id) {
        Stock stock = modelMapper.map(this.findById(id),Stock.class);
        this.stockRepository.delete(stock);
    }
    @Transactional
    public StockDto findById(Long id) {
        Stock stock = this.stockRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.STOCK_NOT_FOUND));
        return modelMapper.map(stock,StockDto.class);
    }
    @Transactional
    public List<StockDto> findAll() {
        List<StockDto> stockDtoList = new ArrayList<>();
        List<Stock> stockList = this.stockRepository.findAll();
        for(Stock s: stockList) {
            stockDtoList.add(modelMapper.map(s,StockDto.class));
        }
        return stockDtoList;
    }
    @Transactional
    public List<StockDto> findByToday() {
        List<StockDto> stockList =  this.stockRepository.findByData(LocalDate.now()).stream().map(s -> modelMapper.map(s,StockDto.class)).collect(Collectors.toList());
        return stockList;
    }
}
