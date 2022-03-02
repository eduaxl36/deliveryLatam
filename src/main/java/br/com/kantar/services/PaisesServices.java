/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.services;

import br.com.kantar.exception.ExistValueException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kantar.models.Paises;
import br.com.kantar.exception.NotFoundException;
import br.com.kantar.modelMessage.ModelMessage;
import br.com.kantar.repository.PaisesRepository;

/**
 *
 * @author eduardo
 */
@Service
public class PaisesServices {

    @Autowired
    private PaisesRepository paisRepository;

    public List<Paises> obterTodosPaises() {

        return paisRepository.findAll();

    }

    public Optional<Paises> obterPorId(int id) {

        Optional<Paises> Pais = paisRepository.findById(id);

        if (Pais.isEmpty()) {

            throw new NotFoundException("O id informado é invalido!!");

        }

        return paisRepository.findById(id);

    }

    public Optional<Paises> obterPaisPorNome(String nome) {

        return paisRepository.findByNome(nome);

    }

    public Object inserirPais(Paises pais) {

        Optional<Paises> VarPaisInternalScope = obterPaisPorNome(pais.getNome());
        
        if(VarPaisInternalScope.isPresent()){
        
            
             throw new ExistValueException("O pais mencionado ja encontra-se na base dados, verifique os dados e digite novamente.");
       
             
        }
        
       paisRepository.save(pais);
        
       return new ModelMessage(200, "Dados inseridos com sucesso!");

    }

    public Object atualizarPais(int codigo, Paises pais) {


        Paises VarPaisInternalScope = obterPorId(codigo).get();


        boolean ValidaSePaisEstaNaBase = obterPaisPorNome(VarPaisInternalScope.getNome()).isPresent();


        boolean ValidaSeNomePaisEigual = VarPaisInternalScope.getNome().equals(pais.getNome());


        if ((ValidaSePaisEstaNaBase) && !(ValidaSeNomePaisEigual)) {

            throw new ExistValueException("O nome do pais fornecido é pertencente a outro registro, verifique os dados e digite novamente.");

        } else if ((ValidaSePaisEstaNaBase) && (ValidaSeNomePaisEigual)) {

            BeanUtils.copyProperties(pais, VarPaisInternalScope, "id");
            paisRepository.save(VarPaisInternalScope);

            return new ModelMessage(200, "Dados atualizados com sucesso!");

        }

        return new ModelMessage(200, "Dados atualizados com sucesso!");

    }

    public void deletarPais(int codigo) {

        paisRepository.deleteById(codigo);

    }

}
