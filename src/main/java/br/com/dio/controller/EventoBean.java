package br.com.dio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dio.model.Evento;

@Named
@ViewScoped
public class EventoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Evento evento;
	
	private List<Evento> eventos = new ArrayList<>();

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	//quando é um arquivo que vai vim de um formulario, ele não precisa ter um parametro de entrada
	public String addEvento() {
		eventos.add(evento);
		System.out.println("Evento adicionado! " + evento.getNome());
		clean();
		return "";
	}
	
	private void clean() {
		this.evento = new Evento();
	}
}
