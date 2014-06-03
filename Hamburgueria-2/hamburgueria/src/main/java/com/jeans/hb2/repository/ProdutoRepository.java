package com.jeans.hb2.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeans.hb2.model.Produto;

@Repository("produtoRepository")
public class ProdutoRepository extends AbstractRepository<Produto> {
    
	@SuppressWarnings("unchecked")
    public List<Produto> getAll() {
        return entityManager.createQuery("SELECT u FROM Produto u ORDER BY u.id").getResultList();
    }
	

	
	public Produto get(Long id){
		return (Produto) entityManager.createQuery("SELECT u FROM Produto u WHERE u.id = :id").setParameter("id", id);
	}

	
	
	public Produto getById(Long id){
		return entityManager.find(Produto.class, id);
	}
	
	
	public void removeById(Long id){
		Produto p = entityManager.find(Produto.class, id);
		entityManager.remove(entityManager.merge(p));
	}
	

}
