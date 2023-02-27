package br.com.projeto.teste.dto;

import br.com.projeto.teste.entity.Produto;

public class ProdutoDto {
    
    private Long id;
    private String codigoBarras;
    private String nome;
    private Integer quantidadeMinima;
    private Integer saldoInicial;
    
    public ProdutoDto() {}
    
    public ProdutoDto(Long id, String codigoBarras, String nome, Integer quantidadeMinima, Integer saldoInicial) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.quantidadeMinima = quantidadeMinima;
        this.saldoInicial = saldoInicial;
    }
    
    public ProdutoDto(Produto produto) {
    }

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

    public Object getPreco() {
        return null;
    }

    public Object getDescricao() {
        return null;
    }
}
