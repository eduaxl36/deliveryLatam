package br.com.kantar.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kantar.models.Produtos;
import br.com.kantar.services.ProdutosServices;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
	
    
@Autowired
private ProdutosServices ProdutoService;


@GetMapping("/recuperaProdutoPorPaisETipo/{paisfk}/{tipo}")
public ResponseEntity<Optional<Produtos>> ObterProdutoPorPaisETipo(@PathVariable String paisfk,@PathVariable String tipo){  

Optional<Produtos> produto = ProdutoService.ObterPorPaisETipo(paisfk,tipo);

return ResponseEntity.ok().body(produto);

}


@GetMapping("/recuperaIdPorPaisETipo/{paisfk}/{tipo}")
public ResponseEntity<Integer> ObterIdPorPaisETipo(@PathVariable String paisfk,@PathVariable String tipo){  

return ResponseEntity.ok().body(ProdutoService.ObterIdPorPaisETipo(paisfk, tipo));

}


@GetMapping("/recuperaListaProdutoPorPais/{paisfk}")
public ResponseEntity<String> ObterListaPorPais(@PathVariable String paisfk){  

String produto = ProdutoService.ObterPorPais(paisfk);

return ResponseEntity.ok().body(produto);

}

@PostMapping

public ResponseEntity<Produtos> salvar(@RequestBody Produtos produto){
	
	Produtos produtoSalvo = ProdutoService.salvarProduto(produto);
	return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	
}


@PutMapping

public ResponseEntity<Produtos> atualizar(@PathVariable(value="id") int id,@RequestBody Produtos produto){
	
	
	return ResponseEntity.ok(ProdutoService.AtualizarProduto(id, produto));
	
}


@DeleteMapping("/{id}")

public Map<String, Boolean> deletar(@PathVariable(value="id") int id){
	
   	 ProdutoService.excluirProduto(id);
	 
   	 Map<String, Boolean> response = new HashMap<>();
	 
   	 response.put("deleted", Boolean.TRUE);
	 
     return response;
	
}









}
