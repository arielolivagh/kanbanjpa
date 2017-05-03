package com.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.domain.DomainArticle;
import com.proyecto.domain.DomainColumn;
import com.proyecto.model.Article;
import com.proyecto.model.Column;
import com.proyecto.repository.RepositoryColumn;

@Controller
public class ControllerColumn {
	@RequestMapping("/column")
	@ResponseBody
	public String index(){
		return "{\"columns\":[{\"titulo\":\"Backlog\",\"article\":[{\"nombre\":\"Nombre\",\"titulo\":\"Titulo\",\"descripcion\":\"Descripcion\"},{\"nombre\":\"Sistema Kanban\",\"titulo\":\"FrontEnd\",\"descripcion\":\"Construir un sistema Kanbad de forma dinamica con json, javascript y jquery\"}]},{\"titulo\":\"Proceso\",\"article\":[]},{\"titulo\":\"Terminado\",\"article\":[]}]}";
	}
	
	@RequestMapping(value="/columnas", method=RequestMethod.GET)
	@ResponseBody
	public List<DomainColumn> getList(){
		List<DomainColumn> columnas = new ArrayList<DomainColumn>();
		List<Column> listColumn = repositoryColumn.getList();
		for (Column colum : listColumn) {
			DomainColumn domainColumn = new DomainColumn();
			domainColumn.setId(colum.getId());
			domainColumn.setTitulo(colum.getTitulo());
			
			List<DomainArticle> articulos = new ArrayList<DomainArticle>();
			for (Article articulo : colum.getArticles()) {
				DomainArticle domainArticle = new DomainArticle();
				domainArticle.setId(articulo.getId());
				domainArticle.setDescripcion(articulo.getDescripcion());
				domainArticle.setNombre(articulo.getNombre());
				domainArticle.setTitulo(articulo.getTitulo());
				articulos.add(domainArticle);
			}
			domainColumn.setArticle(articulos);
			columnas.add(domainColumn);
		}
		return columnas;
	}

	@Autowired
	private RepositoryColumn repositoryColumn;
}
