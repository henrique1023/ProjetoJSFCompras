package br.com.dio.model;

public enum FormaDePagamento {
	CREDITO(1),
	DINHEIRO(2),
	DEBITO(3),
	BOLETO(4);
	
	public int valorTipo;
	FormaDePagamento(int valor){
		valorTipo = valor;
	}
}
