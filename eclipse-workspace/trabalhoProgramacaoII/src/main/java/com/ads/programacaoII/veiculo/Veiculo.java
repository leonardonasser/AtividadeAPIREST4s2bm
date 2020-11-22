package com.ads.programacaoII.veiculo;

import javax.persistence.Entity;

import com.ads.programacaoII.persistence.BaseEntity;


@Entity
public class Veiculo extends BaseEntity {
	
	
	private String nome;
	
	private String placa;
	 
	private Tipo tipo;
	
	 private String marca;
	 
	 
	 public Veiculo() {
		 super();
	 }


	public Veiculo(String nome, String placa, Tipo tipo, String marca) {
		this();
		this.nome = nome;
		this.placa = placa;
		this.tipo = tipo;
		this.marca = marca;
	}


	public String getNome() {
		return nome;
	}


	public String getPlaca() {
		return placa;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public String getMarca() {
		return marca;
	}
	 
	
	
	 
	 

}
