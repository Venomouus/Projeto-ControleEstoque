package br.com.projeto.teste.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.teste.dto.MovimentacaoDto;
import br.com.projeto.teste.entity.Movimentacao;
import br.com.projeto.teste.entity.Produto;
import br.com.projeto.teste.entity.TipoMovimentacao;
import br.com.projeto.teste.repository.MovimentacaoRepository;
import br.com.projeto.teste.repository.MovimentacaoTipoRepository;
import br.com.projeto.teste.repository.ProdutoRepository;

@Service
public class MovimentacaoService {

    private MovimentacaoRepository movimentacaoRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, 
                               MovimentacaoTipoRepository movimentacaoTipoRepository,
                               ProdutoRepository produtoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    public void lancarMovimentacao(MovimentacaoDto movimentacaoDto) throws Exception {
        Produto produto = produtoRepository.findById(movimentacaoDto.getProduto())
                .orElseThrow(() -> new Exception("Produto não encontrado"));

        if (movimentacaoDto.getTipoMovimentacao() == TipoMovimentacao.SALDO_INICIAL && 
                produto.getMovimentacoes().stream().anyMatch(m -> m.getTipoMovimentacao() == TipoMovimentacao.SALDO_INICIAL)) {
            throw new Exception("Já existe uma movimentação de saldo inicial para esse produto");
        }

        if (movimentacaoDto.getTipoMovimentacao() != TipoMovimentacao.SALDO_INICIAL && 
                produto.getMovimentacoes().stream().noneMatch(m -> m.getTipoMovimentacao() == TipoMovimentacao.SALDO_INICIAL)) {
            throw new Exception("Não há uma movimentação de saldo inicial para esse produto");
        }

        if (movimentacaoDto.getTipoMovimentacao() == TipoMovimentacao.AJUSTE_ENTRADA ||
                movimentacaoDto.getTipoMovimentacao() == TipoMovimentacao.AJUSTE_SAIDA) {
            if (produto.getMovimentacoes().size() == 0) {
                throw new Exception("Não é possível fazer ajuste de estoque sem movimentações anteriores");
            }
        }

        Movimentacao movimentacao = new Movimentacao(null, produto, null, null, null, null, null);
        movimentacao.setProduto(produto);
        movimentacao.setTipoMovimentacao(movimentacaoDto.getTipoMovimentacao());
        movimentacao.setQuantidade(movimentacaoDto.getQuantidade());
        movimentacao.setData(movimentacaoDto.getData());
        movimentacao.setMotivo(movimentacaoDto.getMotivo());
        movimentacao.setDocumento(movimentacaoDto.getDocumento());

        movimentacaoRepository.save(movimentacao);
    }

    public void salvarMovimentacao(Movimentacao movimentacao) {
    }

    public MovimentacaoDto cadastrarMovimentacao(MovimentacaoDto movimentacaoDto) {
        return null;
    }

    public List<MovimentacaoDto> listarMovimentacoes() {
        return null;
    }

    public MovimentacaoDto buscarMovimentacao(Long id) {
        return null;
    }

}


