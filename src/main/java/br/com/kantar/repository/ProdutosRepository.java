package br.com.kantar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kantar.models.Paises;
import br.com.kantar.models.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

	
	public List<Produtos> findBytipo(String tipo);
	
    public Optional<Produtos> findBypaisAndTipo(Paises pais,String tipo);
    
    public List<Produtos> findBypais(Paises pais);
	
	
}
