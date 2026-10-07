package com.produtoapi.controller;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable Long id) {
        return produtoService.listarProdutoPorId(id);
    }

    @PostMapping()
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id,@RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

    @PostMapping("/salvarLista")
    public List<Produto> createListProdutos(@RequestBody List<Produto> produtos) {
        return produtoService.salvarProdutos(produtos);
    }

    @GetMapping("/buscarPorNome")
    public List<Produto> getProdutosPorNome(@RequestParam String nome) {
        return produtoService.listarPorNome(nome);
    }

    @GetMapping("/buscarContendo")
    public List<Produto> getProdutosContendo(@RequestParam String nome) {
        return produtoService.listarPorNomeContendo(nome);
    }

    @GetMapping("/buscarPorNomeEStatus")
    public List<Produto> getProdutosPorNomeEStatus(@RequestParam String nome, @RequestParam String status) {
        return produtoService.listarPorNomeAndStatus(nome, status);
    }

    @GetMapping("/buscarPorNomeComecandoCom")
    public List<Produto> getProdutosPorNomeComecandoCom(@RequestParam String nome) {
        return produtoService.listarPorNomeComecandoCom(nome);
    }

    @GetMapping("/buscarPorNomeTerminadoCom")
    public List<Produto> getProdutosPorNomeTerminadoCom(@RequestParam String nome) {
        return produtoService.listarPorNomeTerminadoEm(nome);
    }

    @GetMapping("/preco")
    public List<Produto> getProdutosPorPreco(@RequestParam double preco) {
        return produtoService.listarPorPreco(preco);
    }

    @GetMapping("/precoMaiorQue")
    public List<Produto> getProdutosPorPrecoMaiorQue(@RequestParam double preco) {
        return produtoService.listarPorPrecoMaiorQue(preco);
    }

    @GetMapping("/precoMenorQue")
    public List<Produto>  getProdutosPorPrecoMenorQue(@RequestParam double preco) {
        return produtoService.listarPorPrecoMenorThan(preco);
    }

    @GetMapping("/totalPreco")
    public Double getTotalPreco() {
        return produtoService.listarPrecoTotal();
    }

    @GetMapping("/listarQuantidade")
    public List<Produto> getProdutosPorQuantidade(@RequestParam Integer quantidade) {
        return produtoService.listarQuantidade(quantidade);
    }

    @GetMapping("/quantidadeMaiorQue")
    public List<Produto> getProdutoPorQuantidadeMaiorQue(@RequestParam Integer quantidade) {
        return produtoService.listarPorQuantidadeMaiorQue(quantidade);
    }

    @GetMapping("/quantidadeMenorQue")
    public List<Produto> getProdutosPorQuantidadeMenorQue(@RequestParam Integer quantidade) {
        return produtoService.listarPorQuantidadeMenorQue(quantidade);
    }

    @GetMapping("/listarStatus")
    public List<Produto> getProdutosPorStatus(@RequestParam String status) {
        return produtoService.listarPorStatus(status);
    }

    @GetMapping("/listarStatusVazio")
    public List<Produto> getProdutosPorStatusVazio() {
        return produtoService.listarPorStatusVazio();
    }

    @GetMapping("/listarPrecoStatus")
    public List<Produto> getProdutosPorPrecoAndStatus(@RequestParam Double preco, @RequestParam String status) {
        return produtoService.listarPorPrecoAndStatus(preco, status);
    }

    @GetMapping("/totalProdutos")
    public Long getTotalProdutos() {
        return produtoService.quantidadeTotalDeProdutos();
    }
}
