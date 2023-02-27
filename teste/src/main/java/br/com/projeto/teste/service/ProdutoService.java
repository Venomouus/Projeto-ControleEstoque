package br.com.projeto.teste.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.teste.dto.ProdutoDto;
import br.com.projeto.teste.entity.Produto;
import br.com.projeto.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(ProdutoDto produtoDto) {
        Produto produto = new Produto(null, null, null, null, null, null);
        produto.setNome(produtoDto.getNome());
        produto.setCodigoBarras(produtoDto.getCodigoBarras());
        produto.setPreco(produtoDto.getPreco());
        produto.setDescricao(produtoDto.getDescricao());

        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorCodigo(Long codigo) {
        return produtoRepository.findById(codigo)
                .orElseThrow();
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void atualizarProduto(Long codigo, ProdutoDto produtoDto) {
        Produto produto = buscarProdutoPorCodigo(codigo);

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setDescricao(produtoDto.getDescricao());

        produtoRepository.save(produto);
    }

    public void deletarProdutoPorCodigo(Long codigo) {
        Produto produto = buscarProdutoPorCodigo(codigo);

        produtoRepository.delete(produto);
    }
}




