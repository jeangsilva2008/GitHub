package com.jeans.hb2.controller;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jeans.hb2.model.Item;
import com.jeans.hb2.model.Pedido;
import com.jeans.hb2.model.Produto;

public class PedidoControllerTest extends TestCase {
	

	    private static final String REST_SERVICE_URL = "http://localhost:8080/hamburgueria-2/pedido";
	    private RestTemplate restTemplate;
	 
	    public void beforeClass() {
	        restTemplate = new RestTemplate();
	        
	    }

	 
	    public void testLeitura() {
	        Pedido pCriado = createPedido();
	        Pedido p = restTemplate.getForObject(REST_SERVICE_URL + "/{id}", Pedido.class, "1");
	        assertPedido(p, pCriado);
	    }
	 
	 
	    
	    
	    public Pedido createPedido() {
	        Pedido p = new Pedido();
	        p.setId(1l);
	        p.setDescricao("Cheese Burger");
	        p.setData(Calendar.getInstance());
	        p.setDataFinalizacao(null);
	        p.setFinalizado(false);
	        p.setNumMesa(1);
	        
	        List<Item> itens = new ArrayList<Item>();
	        itens.add(createItem());
	        p.setItens(itens);

	        return p;
	    }
	 
	    public void assertPedido(Pedido actual, Pedido expected) {
	        assertTrue(actual.getId() > 0);
	        assertEquals(actual.getDescricao(), expected.getDescricao());
	        assertEquals(actual.getData(), expected.getData());
	    }
  
	    
	    public Item createItem(){
	    	Item i= new Item();
	    	Produto p = new Produto();
	    	p.setId(1l);
	    	p.setNome("Produto 1");
	    	p.setDescricao("Descricao produto 1");
	    	p.setPreco(new Double(10));
	    	
	    	i.setId(1l);
	    	i.setProduto(p);
	    	i.setQuantidade(2);
	    	i.setValorUnitario(new Double(10));
	    	
	    	return i;
	    	
	    }
   
	    
	    
	    
}


