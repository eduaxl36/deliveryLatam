/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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

/**
 *
 * @author eduardo
 */


@Table(name = "tb_sla_semanal")
@Entity

public class SlaSemanal implements Serializable {
    
   
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
    
    @Column(name = "semana_producao")
    private int SemanaProducao;
    
    @Column(name = "data_sla")
    private LocalDate DataSla;
    
    @Column(name = "horario")
    private LocalTime Horario;
    
    @Column(name = "posicao_dia_semana")
    private int posicaoDiaDaSemana;

    
    public SlaSemanal() {
    }

    public SlaSemanal(int Id, Paises Pais, Produtos Produto, int SemanaProducao, LocalDate DataSla, LocalTime Horario, int posicaoDiaDaSemana) {
        this.Id = Id;
        this.Pais = Pais;
        this.Produto = Produto;
        this.SemanaProducao = SemanaProducao;
        this.DataSla = DataSla;
        this.Horario = Horario;
        this.posicaoDiaDaSemana = posicaoDiaDaSemana;
    }

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

    public int getSemanaProducao() {
        return SemanaProducao;
    }

    public void setSemanaProducao(int SemanaProducao) {
        this.SemanaProducao = SemanaProducao;
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

    public int getPosicaoDiaDaSemana() {
        return posicaoDiaDaSemana;
    }

    public void setPosicaoDiaDaSemana(int posicaoDiaDaSemana) {
        this.posicaoDiaDaSemana = posicaoDiaDaSemana;
    }

    @Override
    public String toString() {
        return "SlaSemanal{" + "Id=" + Id + ", Pais=" + Pais + ", Produto=" + Produto + ", SemanaProducao=" + SemanaProducao + ", DataSla=" + DataSla + ", Horario=" + Horario + ", posicaoDiaDaSemana=" + posicaoDiaDaSemana + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.Id;
        hash = 41 * hash + Objects.hashCode(this.Pais);
        hash = 41 * hash + Objects.hashCode(this.Produto);
        hash = 41 * hash + this.SemanaProducao;
        hash = 41 * hash + Objects.hashCode(this.DataSla);
        hash = 41 * hash + Objects.hashCode(this.Horario);
        hash = 41 * hash + this.posicaoDiaDaSemana;
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
        final SlaSemanal other = (SlaSemanal) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.SemanaProducao != other.SemanaProducao) {
            return false;
        }
        if (this.posicaoDiaDaSemana != other.posicaoDiaDaSemana) {
            return false;
        }
        if (!Objects.equals(this.Pais, other.Pais)) {
            return false;
        }
        if (!Objects.equals(this.Produto, other.Produto)) {
            return false;
        }
        if (!Objects.equals(this.DataSla, other.DataSla)) {
            return false;
        }
        return Objects.equals(this.Horario, other.Horario);
    }
    
    
     public static void main(String[] args) {
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
  
        
        List<SlaSemanal> lst = em.createQuery("from SlaSemanal").getResultList();
        
        lst.forEach(x->{
        
            System.out.println(x);
        
        });
//        
        
        
        
        
        
//        em.getTransaction().begin();
//        
//        Paises pais =    em.find(Paises.class, 4);
//        
//        Produtos pds = new Produtos(pais,"uruguay","uy");
//
//        em.persist(pds);
//        
//        em.getTransaction().commit();
//        
//
//        System.out.println("FIM");
        
        
        
        
    }
    
    
    
    
}
