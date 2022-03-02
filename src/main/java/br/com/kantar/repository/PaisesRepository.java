/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kantar.models.Paises;

/**
 *
 * @author eduardo
 */
@Repository
public interface PaisesRepository extends JpaRepository<Paises, Integer> {
    
	Optional<Paises> findByNome(String pNome);
	
}
