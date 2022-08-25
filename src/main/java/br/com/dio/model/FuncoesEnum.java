package br.com.dio.model;

public enum FuncoesEnum {
	ADMINISTRADOR(1),
	VENDEDOR(2),
	ANALISTA(3);
	
	public int valorTipo;
	FuncoesEnum(int valor){
		valorTipo = valor;
	}
	
}
