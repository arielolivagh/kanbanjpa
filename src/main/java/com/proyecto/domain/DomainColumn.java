package com.proyecto.domain;

import java.io.Serializable;
import java.util.List;

public class DomainColumn implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private List<DomainArticle> article;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<DomainArticle> getArticle() {
		return article;
	}
	public void setArticle(List<DomainArticle> article) {
		this.article = article;
	}
	
	
}