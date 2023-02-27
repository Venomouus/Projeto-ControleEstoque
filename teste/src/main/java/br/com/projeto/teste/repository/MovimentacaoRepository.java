package br.com.projeto.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.teste.entity.Movimentacao;
import br.com.projeto.teste.entity.Produto;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
  
  List<Movimentacao> findByProduto(Produto produto);
  
}

