package com.jeans.hb2.business;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeans.hb2.model.Pedido;
import com.jeans.hb2.repository.PedidoRepository;
 
@Service("pedidoService")
@Transactional(readOnly=true)
public class PedidoServiceImpl implements PedidoService {
 
    @Autowired
    private PedidoRepository pedidoRepository;
     
    public List<Pedido> getAll() {

        return pedidoRepository.getAll();
    }
    
    @Transactional(readOnly = false)
    public Pedido create(Pedido user) throws ParseException {

    	return pedidoRepository.merge(user);
        
    }
    
    
    public void removeById(Long id) throws ParseException{
    	pedidoRepository.removeById(id);
    }

    
   
    public Pedido getById(Long id){
    	return pedidoRepository.getById(id);
    }
    
}
