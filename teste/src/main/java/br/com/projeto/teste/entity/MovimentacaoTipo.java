package br.com.projeto.teste.entity;

import java.time.LocalDateTime;

public class MovimentacaoTipo {
    public static final LocalDateTime SALDO_INICIAL = null;
    public static final String AJUSTE_ENTRADA = null;
    public static final String AJUSTE_SAIDA = null;
    public static final String SAIDA = null;
    private Long id;
    private String descricao;
    
    public MovimentacaoTipo(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static MovimentacaoTipo valueOf(Object tipoMovimento) {
        return null;
    }
}

