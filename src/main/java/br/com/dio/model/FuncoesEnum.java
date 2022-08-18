package br.com.dio.model;

import javax.persistence.Entity;

public enum FuncoesEnum {
	ADMINISTRADOR(1),
	VENDEDOR(2),
	ANALISTA(3);
	
	public int valorTipo;
	FuncoesEnum(int valor){
		valorTipo = valor;
	}
	
}
