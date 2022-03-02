package br.com.kantar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.kantar.models.Paises;
import br.com.kantar.models.Produtos;
import br.com.kantar.repository.PaisesRepository;
import br.com.kantar.repository.ProdutosRepository;

@Service
public class ProdutosServices {
	
	  @Autowired
	  private ProdutosRepository produtoRepository;  
	  
	  @Autowired
	  private PaisesRepository paisRepository;  
	    
	  public Optional<Produtos>findById(int id){return produtoRepository.findById(id);}
	  
	  public Optional<Produtos> ObterPorPaisETipo(String nome,String tipo)
	  {
		  Optional<Paises> Pais = paisRepository.findByNome(nome);
                  
                  if(Pais.isEmpty()){
                  
                
                      
                  
                  }
		  
		  Optional<Produtos> produtos = produtoRepository.findBypaisAndTipo(Pais.get(),tipo);
		  
		  return produtos;
		  
      }	  
	  
	 
	  public int ObterIdPorPaisETipo(String nome,String tipo)
	  {
		  Paises Pais = paisRepository.findByNome(nome).get();
		  
		  Optional<Produtos> produtos = produtoRepository.findBypaisAndTipo(Pais,tipo);
		  
		  return produtos.get().getId();
		  
      }	
	  
	  
	  
	  public String ObterPorPais(String nome)
	  {
		  Paises Pais = paisRepository.findByNome(nome).get();
		  
		  List<Produtos> produtos = produtoRepository.findBypais(Pais);
		  
		  List<String>varControleProdutosNomes = new ArrayList();
		  
		  Gson internalConverterToJson = new Gson();
		  
		  
		  produtos.forEach(x->{
			  
			  varControleProdutosNomes.add(x.getTipo());
				
			});
			 
		  	
		  
		  
		  return internalConverterToJson.toJson(varControleProdutosNomes);
		  
      }	  
	  
	  
	  public Produtos salvarProduto(Produtos produto) {
		  
		  return produtoRepository.save(produto);
		  
	  }
	  
	  
	  public Produtos AtualizarProduto(int codigo,Produtos produtos) {
		  
			Produtos produtoSalvar =validarSeProdutoExiste(codigo);
			BeanUtils.copyProperties(produtos, produtoSalvar,"id");
			
			return produtoRepository.save(produtoSalvar);
			  
			   
		  }


	  private Produtos validarSeProdutoExiste(int id) {
			
			Optional<Produtos>produto= findById(id);
			if(produto.isEmpty()) {
				
				throw new EmptyResultDataAccessException(1);
			}
			return produto.get();
			
			
		}
	    

	  
	  
	  public void excluirProduto(int codigo) {
		  
		  validarSeProdutoExiste(codigo);
		  produtoRepository.deleteById(codigo);
		  
	  }
	  
	  
}
