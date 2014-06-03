package com.jeans.hb2.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeans.hb2.model.Pedido;

public class JdbcPedidoDao {
	
	List<Pedido> l = new ArrayList<>();
	
	public List<Pedido> list(int offset, int t){
		
		Pedido p1 = new Pedido();
		p1.setId(1l);
		p1.setDescricao("Pedido 1");
		p1.setFinalizado(false);
		p1.setDataFinalizacao(null);
		
		Pedido p2 = new Pedido();
		p2.setId(2l);
		p2.setDescricao("Pedido 2");
		p2.setFinalizado(false);
		p2.setDataFinalizacao(null);
		
		l.add(p1);
		l.add(p2);
		
		return l;
		
	}
			
			
	public void excluir(Pedido pedido){
		
		for(Pedido p : l){
			if(p.getId().equals(pedido.getId())){
				l.remove(pedido);
			}
		}
		
	}

	
	public Pedido get(Long id){
		Pedido pedido = null;
		
		for(Pedido p : l){
			if(p.getId().equals(id)){
				pedido = p;
			}
		}
		
		return pedido;
		
	}


	public void persistir(Pedido pedido){
		
		for(Pedido p : l){
			if(p.getId().equals(pedido.getId())){
				p.setDescricao(pedido.getDescricao());
				p.setDataFinalizacao(pedido.getDataFinalizacao());
				p.setFinalizado(pedido.isFinalizado());
			}
		}
		
	}

}
