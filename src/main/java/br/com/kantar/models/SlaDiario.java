/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Objects;
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

@Table(name = "tb_sla")
@Entity

public class SlaDiario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_sla", nullable = false) 
    private int Id;
   
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="id_pais_fk")
    private Paises Pais;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="id_produto_fk")   
    private Produtos Produto;
    
    @Column(name = "data_producao")
    private LocalDate DataProducao;
    
    @Column(name = "data_sla")
    private LocalDate DataSla;
    
    @Column(name = "horario")
    private LocalTime Horario;
    
    @Column(name = "posicao_dia_semana")
    private int numeradorSemana;
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Paises getPais() {
        return Pais;
    }

    public void setPais(Paises Pais) {
        this.Pais = Pais;
    }

    public Produtos getProduto() {
        return Produto;
    }

    public void setProduto(Produtos Produto) {
        this.Produto = Produto;
    }

    public LocalDate getDataProducao() {
        return DataProducao;
    }

    public void setDataProducao(LocalDate DataProducao) {
        this.DataProducao = DataProducao;
    }

    public LocalDate getDataSla() {
        return DataSla;
    }

    public void setDataSla(LocalDate DataSla) {
        this.DataSla = DataSla;
    }

    public LocalTime getHorario() {
        return Horario;
    }

    public void setHorario(LocalTime Horario) {
        this.Horario = Horario;
    }

    public int getNumeradorSemana() {
        return numeradorSemana;
    }

    public void setNumeradorSemana(int numeradorSemana) {
        this.numeradorSemana = numeradorSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.Id;
        hash = 23 * hash + Objects.hashCode(this.Pais);
        hash = 23 * hash + Objects.hashCode(this.Produto);
        hash = 23 * hash + Objects.hashCode(this.DataProducao);
        hash = 23 * hash + Objects.hashCode(this.DataSla);
        hash = 23 * hash + Objects.hashCode(this.Horario);
        hash = 23 * hash + this.numeradorSemana;
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
        final SlaDiario other = (SlaDiario) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.numeradorSemana != other.numeradorSemana) {
            return false;
        }
        if (!Objects.equals(this.Pais, other.Pais)) {
            return false;
        }
        if (!Objects.equals(this.Produto, other.Produto)) {
            return false;
        }
        if (!Objects.equals(this.DataProducao, other.DataProducao)) {
            return false;
        }
        if (!Objects.equals(this.DataSla, other.DataSla)) {
            return false;
        }
        return Objects.equals(this.Horario, other.Horario);
    }

    @Override
    public String toString() {
        return "SlaDiario{" + "Id=" + Id + ", Pais=" + Pais + ", Produto=" + Produto + ", DataProducao=" + DataProducao + ", DataSla=" + DataSla + ", Horario=" + Horario + ", numeradorSemana=" + numeradorSemana + '}';
    }
      
    
}
