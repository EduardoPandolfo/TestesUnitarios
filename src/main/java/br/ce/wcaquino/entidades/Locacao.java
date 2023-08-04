package br.ce.wcaquino.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Locacao {

    private Usuario usuario;
    private List<Filme> filmes;
    private LocalDate dataLocacao;
    private LocalDate dataRetorno;
    private Double valor;

}