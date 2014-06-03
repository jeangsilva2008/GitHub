package com.jeans.hb2.business;

import java.util.List;

import com.jeans.hb2.model.Produto;

 
public interface ProdutoService {
     
	   List<Produto> getAll() throws Exception;
	   
	   Produto create(Produto produto) throws Exception;
	   
	   public void removeById(Long id) throws Exception;
	   
	   public Produto getById(Long id) throws Exception;
}
