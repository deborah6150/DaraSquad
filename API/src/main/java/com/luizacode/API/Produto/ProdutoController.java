package com.luizacode.API.Produto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //Informa que é um controller
@RequestMapping(value = "api/produto") //Define nome para chamada
@CrossOrigin(origins = "*") ///Define que qualquer origem pode acessar essa API
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping() //Define caminho para chamada
    @ApiOperation(value = "Cadastra um produto.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Produto cadastrado!")
    public ResponseEntity cadastraProduto(@RequestBody Produto produto) {
        return produtoService.cadastraProduto(produto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um produto cadastrado.")
    @ApiResponse(code = 200, message = "Produto deletado!")
    public ResponseEntity deletaProduto(@PathVariable(value = "id") Long id) {
        return produtoService.deletaProduto(id);
    }

    @PutMapping()
    @ApiOperation(value = "Atualiza informações de um produto.")
    @ApiResponse(code = 200, message = "Produto atualizado!")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoService.atualizaProduto(produto);
    }

    @GetMapping()
    @ApiOperation(value = "Lista os produtos cadastrados.")
    public List<Produto> listaProduto() {
        return produtoService.buscaProdutos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna produto específico através id.")
    public Optional listaProdutoUnico(@PathVariable(value = "id") Long id) {
        return produtoService.buscaUmProduto(id);
    }

}
