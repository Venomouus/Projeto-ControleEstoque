package br.com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.teste.entity.MovimentacaoTipo;

@Repository
public interface MovimentacaoTipoRepository extends JpaRepository<MovimentacaoTipo, Long> {

}

