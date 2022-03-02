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

@Table(name = "tb_indicadores_semanais")
@Entity
public class IndicadoresMensais implements Serializable {
 
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   @Column(name = "id_indicador", nullable = false)  
   private int Id;
  
   @Column(name = "entrega_data_efetuada")
   private LocalDate DataEntregaRegistrada;
   
   @Column(name = "entrega_hora_efetuada")
   private LocalTime HoraEntregaRegistrada;
   
   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="id_sla_fk") 
   private SlaDiario Sla;
   
   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="id_pais_fk")  
   private Paises Pais;
   
   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="id_produto_fk")  
   private Produtos Produto;
   
   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="id_motivo_fk")     
   private Justificativas Justificativas;

   @Column(name = "observacao")  
   private String Observacao;

    public IndicadoresMensais() {
    }

    public IndicadoresMensais(int Id, LocalDate DataEntregaRegistrada, LocalTime HoraEntregaRegistrada, SlaDiario Sla, Paises Pais, Produtos Produto, Justificativas Justificativas, String Observacao) {
        this.Id = Id;
        this.DataEntregaRegistrada = DataEntregaRegistrada;
        this.HoraEntregaRegistrada = HoraEntregaRegistrada;
        this.Sla = Sla;
        this.Pais = Pais;
        this.Produto = Produto;
        this.Justificativas = Justificativas;
        this.Observacao = Observacao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public LocalDate getDataEntregaRegistrada() {
        return DataEntregaRegistrada;
    }

    public void setDataEntregaRegistrada(LocalDate DataEntregaRegistrada) {
        this.DataEntregaRegistrada = DataEntregaRegistrada;
    }

    public LocalTime getHoraEntregaRegistrada() {
        return HoraEntregaRegistrada;
    }

    public void setHoraEntregaRegistrada(LocalTime HoraEntregaRegistrada) {
        this.HoraEntregaRegistrada = HoraEntregaRegistrada;
    }

    public SlaDiario getSla() {
        return Sla;
    }

    public void setSla(SlaDiario Sla) {
        this.Sla = Sla;
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

    public Justificativas getJustificativas() {
        return Justificativas;
    }

    public void setJustificativas(Justificativas Justificativas) {
        this.Justificativas = Justificativas;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.Id;
        hash = 31 * hash + Objects.hashCode(this.DataEntregaRegistrada);
        hash = 31 * hash + Objects.hashCode(this.HoraEntregaRegistrada);
        hash = 31 * hash + Objects.hashCode(this.Sla);
        hash = 31 * hash + Objects.hashCode(this.Pais);
        hash = 31 * hash + Objects.hashCode(this.Produto);
        hash = 31 * hash + Objects.hashCode(this.Justificativas);
        hash = 31 * hash + Objects.hashCode(this.Observacao);
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
        final IndicadoresMensais other = (IndicadoresMensais) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Observacao, other.Observacao)) {
            return false;
        }
        if (!Objects.equals(this.DataEntregaRegistrada, other.DataEntregaRegistrada)) {
            return false;
        }
        if (!Objects.equals(this.HoraEntregaRegistrada, other.HoraEntregaRegistrada)) {
            return false;
        }
        if (!Objects.equals(this.Sla, other.Sla)) {
            return false;
        }
        if (!Objects.equals(this.Pais, other.Pais)) {
            return false;
        }
        if (!Objects.equals(this.Produto, other.Produto)) {
            return false;
        }
        return Objects.equals(this.Justificativas, other.Justificativas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndicadoresMensais{");
        sb.append("Id=").append(Id);
        sb.append(", DataEntregaRegistrada=").append(DataEntregaRegistrada);
        sb.append(", HoraEntregaRegistrada=").append(HoraEntregaRegistrada);
        sb.append(", Sla=").append(Sla);
        sb.append(", Pais=").append(Pais);
        sb.append(", Produto=").append(Produto);
        sb.append(", Justificativas=").append(Justificativas);
        sb.append(", Observacao=").append(Observacao);
        sb.append('}');
        return sb.toString();
    }
    
   
   
   
    
}
