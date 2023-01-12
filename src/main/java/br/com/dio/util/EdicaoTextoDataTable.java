package br.com.dio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EdicaoTextoDataTable {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public String dataFormat(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String d = sdf.format(data);
		return d;
	}
	
	public String salaryFormat(Float salario) {
		return "R$" + salario;
	}

}
