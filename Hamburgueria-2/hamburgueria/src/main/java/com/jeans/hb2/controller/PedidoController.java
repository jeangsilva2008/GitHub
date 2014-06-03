package com.jeans.hb2.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeans.hb2.business.PedidoService;
import com.jeans.hb2.business.ProdutoService;
import com.jeans.hb2.model.Item;
import com.jeans.hb2.model.Pedido;
import com.jeans.hb2.model.Produto;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService servicePedido;
	
	@Autowired
	private ProdutoService serviceProduto;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Pedido consultarPedido(@PathVariable Long id) throws Exception {
	  Pedido p = servicePedido.getById(id);
	  return p;
	}
	
	

	@RequestMapping("alterarPedido")
	public String alterarPedido(Long id, Model model) throws Exception {
	  model.addAttribute("pedido", servicePedido.getById(id));
	  return "pedido/alterarPedido";
	}

	
	@RequestMapping("incluirPedido")
	public String incluirPedido(Model model) throws Exception{
		
		List<Produto> l = serviceProduto.getAll();
		model.addAttribute("produtos", l);
		
		return "pedido/incluirPedido";
	}
	
	
	@RequestMapping("incluir")
	public String incluirPedido(@Valid Pedido pedido, Produto produto, BindingResult result) throws Exception{
		
		if(result.hasFieldErrors("descricao")){
			return "pedido/incluirPedido";
		}

		LOGGER.info("Criando novo pedido..", pedido);
		
		Item i = new Item();
		i.setPedido(pedido);
		i.setProduto(produto);
		i.setQuantidade(1);
		i.setValorUnitario(new Double(10));
		
		List<Item> l = new ArrayList<Item>();
		l.add(i);
		
		pedido.setItens(l);
		
		servicePedido.create(pedido);
		return "pedido/pedidoIncluido";
	}

	

	
	@RequestMapping("telaInicial")
	public String telaInicial(){
		return "pedido/telaInicial";
	}
	
	
	
	@RequestMapping("listaPedidos")
	public String lista(Model model) throws Exception {
	  List<Pedido> pedidos = servicePedido.getAll(); 
	  model.addAttribute("pedidos", pedidos);
	  return "pedido/lista";
	}
	
	
	
	@RequestMapping("removerPedido")
	public String remover(Pedido pedido) throws Exception {
		servicePedido.removeById(pedido.getId());
		return "redirect:listaPedidos";
	}
	

	
	
	@RequestMapping("alterar")
	public String alterar(Pedido pedido) throws Exception {
	  servicePedido.create(pedido);
	  return "redirect:listaPedidos";
	}
	
	
	
	@RequestMapping("finalizaPedido")
	public String finaliza(Long id, Model model) throws Exception {
	  Pedido p = servicePedido.getById(id);
	  p.setFinalizado(true);
	  p.setDataFinalizacao(Calendar.getInstance());
	  servicePedido.create(p);

	  model.addAttribute("pedido", p);
	  
	  return "pedido/finalizado";
	
	}
	
}
