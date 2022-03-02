/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author eduardo
 */

@Table(name = "tb_produtos")
@Entity

public class Produtos implements Serializable {
 

	private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  
  @Column(name = "id", nullable = false)  
  private int id;
  
  @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
  @JoinColumn(name="pais")
  private Paises pais;
  

  @Column(name = "nome")
  private String nome;
  
  @Column(name = "tipo")
  private String tipo; 

    public Produtos() {
    }

    

 
    public Produtos(int id, Paises pais, String nome, String tipo) {
		super();
		this.id = id;
		this.pais = pais;
		this.nome = nome;
		this.tipo = tipo;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Paises getPais() {
		return pais;
	}




	public void setPais(Paises pais) {
		this.pais = pais;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}



        
        
        
       
        
        
        
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

