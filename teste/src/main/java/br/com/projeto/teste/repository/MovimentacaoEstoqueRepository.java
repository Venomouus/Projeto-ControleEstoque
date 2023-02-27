package br.com.projeto.teste.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.teste.entity.MovimentacaoEstoque;
import br.com.projeto.teste.entity.TipoMovimentacao;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    
    List<MovimentacaoEstoque> findByProdutoId(Long produtoId);
    
    MovimentacaoEstoque findByProdutoIdAndTipoMovimentacao(Long produtoId, TipoMovimentacao tipoMovimentacao);
    
    List<MovimentacaoEstoque> findByDataGreaterThanEqualAndDataLessThanEqual(LocalDate dataInicio, LocalDate dataFim);
    
    List<MovimentacaoEstoque> findByProdutoIdAndDataGreaterThanEqualAndDataLessThanEqual(Long produtoId, LocalDate dataInicio, LocalDate dataFim);
    
}
