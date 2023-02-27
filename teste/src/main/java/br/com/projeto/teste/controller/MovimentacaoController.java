package br.com.projeto.teste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.teste.dto.MovimentacaoDto;
import br.com.projeto.teste.entity.Movimentacao;
import br.com.projeto.teste.entity.Produto;
import br.com.projeto.teste.service.MovimentacaoService;
import br.com.projeto.teste.service.ProdutoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;
    private final ProdutoService produtoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService, ProdutoService produtoService) {
        this.movimentacaoService = movimentacaoService;
        this.produtoService = produtoService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('OPERADOR', 'GERENTE')")
    public ResponseEntity<?> lancarMovimentacao(@RequestBody @Validated MovimentacaoDto movimentacaoDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Produto produto = produtoService.buscarProdutoPorCodigo(movimentacaoDto.getProdutoId());
        if (produto == null) {
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }

        Movimentacao movimentacao = movimentacaoDto.toMovimentacao(produto);

        try {
            movimentacaoService.salvarMovimentacao(movimentacao);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao lançar movimentação: " + e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}

