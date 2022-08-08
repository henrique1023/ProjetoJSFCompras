package br.com.dio.model;

public enum TipoEnum {
	ADMINISTRADOR(1),
	VENDEDOR(2),
	ANALISTA(3);
	
	public int valorTipo;
	TipoEnum(int valor){
		valorTipo = valor;
	}
	
}
