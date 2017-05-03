package com.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Columns database table.
 * 
 */
@Entity
@Table(name="Columns")
@NamedQuery(name="Column.findAll", query="SELECT c FROM Column c")
public class Column implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String titulo;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="column")
	private List<Article> articles;

	public Column() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setColumn(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setColumn(null);

		return article;
	}

}