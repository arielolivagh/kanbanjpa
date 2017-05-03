package com.proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.model.Article;

@Repository
@Transactional
public class RepositoryArticle {

	public List<Article> getList(){
		return  entityManager.createQuery("from Article").getResultList();
	}
	
	@PersistenceContext
	private EntityManager entityManager; 

}