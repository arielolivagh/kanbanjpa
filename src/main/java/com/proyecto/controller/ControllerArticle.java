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
import com.proyecto.repository.RepositoryArticle;

@Controller
public class ControllerArticle {
	@RequestMapping("/article")
	@ResponseBody
	public String index(){
		return 	"		{\"article\": [{"+
				"			\"nombre\":\"Nombre\",\"titulo\":\"Titulo\",\"descripcion\":\"Descripcion\""+
				"		}, {"+
				"			\"nombre\":\"Sistema Kanban\",\"titulo\":\"FrontEnd\",\"descripcion\":\"Construir un sistema Kanbad de forma dinamica con json, javascript y jquery\""+
				"		}]}";
	}
	
	@RequestMapping(value="/articulos", method=RequestMethod.GET)
	@ResponseBody
	public List<DomainArticle> getList(){
		List<DomainArticle> articulos = new ArrayList<DomainArticle>();
		List<Article> listArticle = repositoryArticle.getList();
		for (Article article : listArticle) {
			DomainArticle domainArticle = new DomainArticle();
			domainArticle.setId(article.getId());
			domainArticle.setDescripcion(article.getDescripcion());
			domainArticle.setNombre(article.getNombre());
			domainArticle.setTitulo(article.getTitulo());
			
			articulos.add(domainArticle);
		}
		return articulos;
	}
	
	@Autowired
	private RepositoryArticle repositoryArticle;
	
}
