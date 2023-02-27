package br.com.projeto.teste.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.projeto.teste.entity.Movimentacao;
import br.com.projeto.teste.entity.MovimentacaoTipo;
import br.com.projeto.teste.entity.Produto;
import br.com.projeto.teste.entity.TipoMovimentacao;

public class MovimentacaoDto {

    private Long id;
    private ProdutoDto produto;
    private MovimentacaoTipo tipo;
    private BigDecimal quantidade;
    private LocalDate data;
    private String motivo;
    private String documento;

    // construtores
    public MovimentacaoDto() {}

    public MovimentacaoDto(Long id, ProdutoDto produto, MovimentacaoTipo tipo, BigDecimal quantidade,
            LocalDate data, String motivo, String documento) {
        this.id = id;
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.motivo = motivo;
        this.documento = documento;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Object getTipoMovimento() {
        return null;
    }

    public Long getProdutoId() {
        return null;
    }

    public Movimentacao toMovimentacao(Produto produto2) {
        return null;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return null;
    }
}

