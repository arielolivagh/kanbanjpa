package com.proyecto.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.model.Column;

@Repository
@Transactional
public class RepositoryColumn {

	public List<Column> getList(){
		return  entityManager.createQuery("from Column").getResultList();
	}
	
	@PersistenceContext
	private EntityManager entityManager; 

}