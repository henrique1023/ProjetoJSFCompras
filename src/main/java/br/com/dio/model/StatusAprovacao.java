package br.com.dio.model;

public enum StatusAprovacao {
	APROVADO(1),
	REPROVADO(2),
	ANALISE(3);
	
	public int valorTipo;
	StatusAprovacao(int valor){
		valorTipo = valor;
	}
}
