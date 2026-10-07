package com.produtoapi.service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> listarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        if(produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado.");
        }
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> salvarProdutos(List<Produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }

    public List<Produto> listarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> listarPorNomeContendo(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> listarPorNomeAndStatus(String nome, String status) {
        return produtoRepository.findByNomeAndStatus(nome, status);
    }

    public List<Produto> listarPorNomeComecandoCom(String nome) {
        return produtoRepository.findByNomeStartingWith(nome);
    }

    public List<Produto> listarPorNomeTerminadoEm(String nome) {
        return produtoRepository.findByNomeEndingWith(nome);
    }

    public List<Produto> listarPorPreco(double preco) {
        return produtoRepository.findByPreco(preco);
    }

    public List<Produto> listarPorPrecoMaiorQue(double preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public  List<Produto> listarPorPrecoMenorThan(double preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public Double listarPrecoTotal() {
        return produtoRepository.findTotalPreco();
    }

    public List<Produto> listarQuantidade(Integer quantidade) {
        return produtoRepository.findByQuantidade(quantidade);
    }

    public List<Produto> listarPorQuantidadeMaiorQue(Integer quantidade) {
        return produtoRepository.findByQuantidadeGreaterThan(quantidade);
    }

    public List<Produto> listarPorQuantidadeMenorQue(Integer quantidade) {
        return produtoRepository.findByQuantidadeLessThan(quantidade);
    }

    public List<Produto> listarPorStatus(String status) {
        return produtoRepository.findByStatus(status);
    }

    public List<Produto> listarPorStatusVazio() {
        return produtoRepository.findByStatusIsNull();
    }

    public List<Produto> listarPorPrecoAndStatus(Double preco, String status) {
        return produtoRepository.findByPrecoAndStatus(preco, status);
    }

    public Long quantidadeTotalDeProdutos() {
        return produtoRepository.count();
    }
}
