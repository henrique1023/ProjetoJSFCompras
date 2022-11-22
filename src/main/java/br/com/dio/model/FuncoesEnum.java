package br.com.dio.model;

public enum FuncoesEnum {
	ADMINISTRADOR(1, "administrador"),
	VENDEDOR(2, "Vendedor"),
	ANALISTA(3, "Analista");
	
	public int valorTipo;
	FuncoesEnum(int valor, String string){
		valorTipo = valor;
	}
	
	public static FuncoesEnum funcaoById(int id) {
		if(id == 0) {
			return FuncoesEnum.ADMINISTRADOR;
		}else if(id == 1) {
			return FuncoesEnum.VENDEDOR;
		}else {
			return FuncoesEnum.ANALISTA;
		}
	}

	public int getValorTipo() {
		return valorTipo;
	}
	
	
}
