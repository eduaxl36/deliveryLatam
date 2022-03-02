/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eduardo
 */

@Table(name = "tb_justificativas")
@Entity

public class Justificativas {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)  
  
   @Column(name = "id_motivo", nullable = false)  
    private int IdMotivo;
   
    @Column(name = "desc_motivo")
    private String DescMotivo;
    
    @Column(name = "abrev")
    private String abreviacao;
    
    @Column(name = "status")
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getDescMotivo() {
        return DescMotivo;
    }

    public void setDescMotivo(String DescMotivo) {
        this.DescMotivo = DescMotivo;
    }

    public int getIdMotivo() {
        return IdMotivo;
    }

    public void setIdMotivo(int IdMotivo) {
        this.IdMotivo = IdMotivo;
    }
    
    public Justificativas() {
    }
    
    public Justificativas(int IdMotivo, String DescMotivo, String abreviacao, String Status) {
        this.IdMotivo = IdMotivo;
        this.DescMotivo = DescMotivo;
        this.abreviacao = abreviacao;
        this.Status = Status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.IdMotivo;
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
        final Justificativas other = (Justificativas) obj;
        return this.IdMotivo == other.IdMotivo;
    }

    
    
    
            
            
    
    
    
}
