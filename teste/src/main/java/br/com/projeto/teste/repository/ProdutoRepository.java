package br.com.projeto.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.teste.dto.ProdutoDto;
import br.com.projeto.teste.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean findByCodigoBarras(String codigoBarras);

    Object findAll(String codigo);

    Optional<Produto> findById(ProdutoDto produto);
}

