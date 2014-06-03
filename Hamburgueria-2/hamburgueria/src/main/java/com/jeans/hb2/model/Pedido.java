package com.jeans.hb2.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="pedido")
public class Pedido {
	
	  @Id
	  @GeneratedValue
	  @Column(name="ID")
	  private Long id;
	  
	  @NotEmpty(message="Descri��o deve ser preenchida!") 
	  @Size(min=5, message="Descri��o deve conter pelo menos 5 caracteres")
	  @Column(name="DESCRICAO")
	  private String descricao;
	  
	  @Column(name="FINALIZADO")
	  private boolean finalizado;
	  
	  @DateTimeFormat(pattern="dd/MM/yyyy")
	  @Column(name="DATAFINALIZACAO") 
	  @Temporal(TemporalType.TIMESTAMP)
	  private Calendar dataFinalizacao;
	  	  
	  @Temporal(TemporalType.DATE)
	  private Calendar data = Calendar.getInstance();
	  
	  @Column(name="NUMMESA")
	  private Integer numMesa;
		
	  @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy="pedido")
	  private List<Item> itens = new ArrayList<Item>();
	  
	  
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Integer getNumMesa() {
		return numMesa;
	}
	public void setNumMesa(Integer numMesa) {
		this.numMesa = numMesa;
	}
	  
}
