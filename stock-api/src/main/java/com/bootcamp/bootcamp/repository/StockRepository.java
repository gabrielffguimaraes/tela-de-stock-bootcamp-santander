package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.dto.StockDto;
import com.bootcamp.bootcamp.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findByNomeAndData(String nome, LocalDate data);

    @Query(value = "select s from Stock s where s.nome=:nome and s.data=:data and s.id!=:id")
    Optional<Stock> findByStockUpdate(@Param("nome") String nome,@Param("data") LocalDate data,@Param("id") Long id);

    List<Stock> findByData(LocalDate data);
}
