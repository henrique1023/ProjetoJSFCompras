package br.com.dio.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@RequestScoped
public class DFViewBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void viewProducts() {
		Map<String, Object> options = new HashMap<>();
		options.put("resizable", false);
		PrimeFaces.current().dialog().openDynamic("viewResetPassword", options, null);
	}

	public void viewResetCustomized() {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		PrimeFaces.current().dialog().openDynamic("viewResetPassword", options, null);
	}
}
