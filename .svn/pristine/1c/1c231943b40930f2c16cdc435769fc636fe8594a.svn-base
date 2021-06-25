package br.com.bingo.funcoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SelectDinamico {
	
	@PersistenceContext
	protected EntityManager manager;

	public List<Object> findCustomNativeQuery(String query) {
	    return manager.createNativeQuery(query).getResultList();
	}
}
