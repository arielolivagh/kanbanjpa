package com.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	private String titulo;

	//bi-directional many-to-one association to Column
	@ManyToOne
	@JoinColumn(name="Columns_id")
	private Column column;

	public Article() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Column getColumn() {
		return this.column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

}