package br.com.projeto.teste.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true)
   private String codigoBarras;

   @Column(nullable = false)
   private String nome;

   @Column(nullable = false)
   private Integer quantidadeMinima;

   @Column(nullable = false, updatable = false)
   private Integer saldoInicial;

   @OneToMany(mappedBy = "produto")
   private List<Movimentacao> movimentacoes = new ArrayList<>();

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getCodigoBarras() {
    return codigoBarras;
}

public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public Integer getQuantidadeMinima() {
    return quantidadeMinima;
}

public void setQuantidadeMinima(Integer quantidadeMinima) {
    this.quantidadeMinima = quantidadeMinima;
}

public Integer getSaldoInicial() {
    return saldoInicial;
}

public void setSaldoInicial(Integer saldoInicial) {
    this.saldoInicial = saldoInicial;
}

public List<Movimentacao> getMovimentacoes() {
    return movimentacoes;
}

public void setMovimentacoes(List<Movimentacao> movimentacoes) {
    this.movimentacoes = movimentacoes;
}

public Produto(Long id, String codigoBarras, String nome, Integer quantidadeMinima, Integer saldoInicial,
        List<Movimentacao> movimentacoes) {
    this.id = id;
    this.codigoBarras = codigoBarras;
    this.nome = nome;
    this.quantidadeMinima = quantidadeMinima;
    this.saldoInicial = saldoInicial;
    this.movimentacoes = movimentacoes;
}

public void setPreco(Object preco) {
}

public void setDescricao(Object descricao) {
}

   // construtores, getters e setters
}


