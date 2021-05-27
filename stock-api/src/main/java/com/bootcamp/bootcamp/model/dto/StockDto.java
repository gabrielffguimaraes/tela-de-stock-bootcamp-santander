package com.bootcamp.bootcamp.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
public class StockDto {
        private Long id;
        @NotNull
        private String nome;
        @NotNull
        @DecimalMin(value="0.00")
        @Digits(integer = 6,fraction = 2)
        private Double valor;
        @NotNull
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        private LocalDate data;
        @NotNull
        @Digits(integer = 3,fraction = 2)
        private Double variacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getVariacao() {
        return variacao;
    }

    public void setVariacao(Double variacao) {
        this.variacao = variacao;
    }
}
