package com.proyecto.domain;

import java.io.Serializable;

import com.proyecto.model.Column;

public class DomainArticle implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion;
	private String nombre;
	private String titulo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}