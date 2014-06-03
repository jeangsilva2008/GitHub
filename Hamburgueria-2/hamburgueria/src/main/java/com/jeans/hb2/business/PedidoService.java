package com.jeans.hb2.business;

import java.util.List;

import com.jeans.hb2.model.Pedido;

 
public interface PedidoService {
	
     
	   List<Pedido> getAll() throws Exception;
	   
	   Pedido create(Pedido user) throws Exception;
	   
	   public void removeById(Long id) throws Exception;
	   
	   public Pedido getById(Long id) throws Exception;
}
