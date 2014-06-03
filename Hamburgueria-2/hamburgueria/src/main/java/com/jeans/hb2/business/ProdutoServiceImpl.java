package com.jeans.hb2.business;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeans.hb2.model.Produto;
import com.jeans.hb2.repository.ProdutoRepository;
 
@Service("produtoService")
@Transactional(readOnly=true)
public class ProdutoServiceImpl implements ProdutoService {
 
    @Autowired
    private ProdutoRepository produtoRepository;
     
    public List<Produto> getAll() {

        return produtoRepository.getAll();
    }
    
    @Transactional(readOnly = false)
    public Produto create(Produto user) throws ParseException {

    	return produtoRepository.merge(user);
        
    }
    
    
    public void removeById(Long id) throws ParseException{
    	produtoRepository.removeById(id);
    }

    
   
    public Produto getById(Long id){
    	return produtoRepository.getById(id);
    }
    
}
