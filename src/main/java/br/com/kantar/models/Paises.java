package br.com.kantar.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eduardo
 */

import java.io.*;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Table(name="tb_paises") 
@Entity
public class Paises implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id",nullable=false)        
private Integer id;

@Column(name = "nome")
@NotBlank(message="VALOR_INVALIDO_PARA_PAIS")
@Length(min=3,max=50,message="TAMANHO_INVALIDO")
private String nome;

@Column(name = "agrupamento")
private String agrupamento;

public Paises() {
}



	public Paises(Integer id, String nome, String agrupamento) {
	super();
	this.id = id;
	this.nome = nome;
	this.agrupamento = agrupamento;
}



	@Override
public String toString() {
	return "Paises [id=" + id + ", nome=" + nome + ", agrupamento=" + agrupamento + "]";
}



	public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getNome() {
	return nome;
}



public void setNome(String nome) {
	this.nome = nome;
}



public String getAgrupamento() {
	return agrupamento;
}



public void setAgrupamento(String agrupamento) {
	this.agrupamento = agrupamento;
}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.agrupamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paises other = (Paises) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.agrupamento, other.agrupamento)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }




}
