package br.com.projeto.teste.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Movimentacao(Long id, Produto produto, MovimentacaoTipo tipo, Integer quantidade, LocalDate data,
            String motivo, String documento) {
        this.id = id;
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.motivo = motivo;
        this.documento = documento;
    }

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private MovimentacaoTipo tipo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate data;

    private String motivo;

    private String documento;

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

    public void setProduto(Produto produto2) {
    }

    public void setQuantidade(BigDecimal quantidade2) {
    }

    public void setData(LocalDate data2) {
    }

    public void setTipoMovimentacao(Object tipoMovimento) {
    }

    public TipoMovimentacao getTipoMovimento() {
        return null;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return null;
    }

    // construtores, getters e setters
}
