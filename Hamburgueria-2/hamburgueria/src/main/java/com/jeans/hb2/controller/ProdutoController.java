package com.jeans.hb2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeans.hb2.business.ProdutoService;
import com.jeans.hb2.model.Produto;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	

	@RequestMapping("novoProduto")
	public String novoProduto(){
		return "produto/formProduto";
	}
	
	
	
	@RequestMapping("incluirProduto")
	public String incluirProduto(@Valid Produto produto, BindingResult result) throws Exception{
		
		if(result.hasFieldErrors("nome")){
			return "produto/formProduto";
		}
		
		service.create(produto);
		System.out.println("Incluindo produto....");
		
		return "produto/produtoIncluido";
	}
	
	
	// ALTERAR PRODUTO
	@RequestMapping("exibirProduto")
	public String exibir(Long id, Model model) throws Exception {
	  model.addAttribute("produto", service.getById(id));
	  return "produto/exibe";
	}
	
	
	
//	@RequestMapping("listaPedidos")
//	public String lista(Model model) throws Exception {
//	  List<Pedido> pedidos = service.getAll(); 
//	  model.addAttribute("pedidos", pedidos);
//	  return "pedido/lista";
//	}
	
	
	
//	@RequestMapping("removerPedido")
//	public String remover(Pedido pedido) throws Exception {
//		service.removeById(pedido.getId());
//		return "redirect:listaPedidos";
//	}
//	
//	
//	@RequestMapping("alterarPedido")
//	public String alterar(Pedido pedido) throws Exception {
//	  service.create(pedido);
//	  return "redirect:listaPedidos";
//	}
//	
//	
//	
//	@RequestMapping("finalizaPedido")
//	public String finaliza(Long id, Model model) throws Exception {
//	  Pedido p = service.getById(id);
//	  p.setFinalizado(true);
//	  p.setDataFinalizacao(Calendar.getInstance());
//	  service.create(p);
//
//	  model.addAttribute("pedido", p);
//	  
//	  return "pedido/finalizado";
//	
//	}
	
}
