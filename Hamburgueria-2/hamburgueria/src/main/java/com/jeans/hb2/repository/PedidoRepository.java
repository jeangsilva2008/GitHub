package com.jeans.hb2.repository;


import java.util.List;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jeans.hb2.model.Pedido;

@Repository("userRepository")
public class PedidoRepository extends AbstractRepository<Pedido> {
    
	@SuppressWarnings("unchecked")
    public List<Pedido> getAll() {
        return entityManager.createQuery("SELECT u FROM Pedido u ORDER BY u.id").getResultList();
    }
	

	
	public Pedido get(Long id){
		return (Pedido) entityManager.createQuery("SELECT u FROM Pedido u WHERE u.id = :id").setParameter("id", id);
	}

	
	
	public Pedido getById(Long id){
		return entityManager.find(Pedido.class, id);
	}
	
	
	public void removeById(Long id){
		Pedido p = entityManager.find(Pedido.class, id);
		entityManager.remove(entityManager.merge(p));
	}
	

}
