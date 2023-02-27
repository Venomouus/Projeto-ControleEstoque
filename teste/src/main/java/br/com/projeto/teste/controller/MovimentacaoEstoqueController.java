package br.com.projeto.teste.controller;

import java.net.URI;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projeto.teste.dto.MovimentacaoDto;
import br.com.projeto.teste.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoEstoqueController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoEstoqueController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping
    public ResponseEntity<MovimentacaoDto> cadastrarMovimentacao(@RequestBody @Validated MovimentacaoDto movimentacaoDto) {
        MovimentacaoDto movimentacaoCadastrada = movimentacaoService.cadastrarMovimentacao(movimentacaoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movimentacaoCadastrada.getId()).toUri();
        return ResponseEntity.created(uri).body(movimentacaoCadastrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoDto> buscarMovimentacao(@PathVariable Long id) {
        MovimentacaoDto movimentacaoDto = movimentacaoService.buscarMovimentacao(id);
        return ResponseEntity.ok(movimentacaoDto);
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoDto>> listarMovimentacoes() {
        List<MovimentacaoDto> movimentacoes = movimentacaoService.listarMovimentacoes();
        return ResponseEntity.ok(movimentacoes);
    }

}


