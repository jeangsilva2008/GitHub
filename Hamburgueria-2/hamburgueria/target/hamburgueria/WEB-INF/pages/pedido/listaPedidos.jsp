<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>
  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
  
  
  <script> type="text/javascript">
  
    $(document).ready(function() {
        $('#btReload').click(function() { location.reload(true); });
        setInterval('refreshPage()', 5000);
    });
    
    function refreshPage() { location.reload(); }
    
</script>
  
  
</head>
<body>
  
  <script type="text/javascript">
  
  function finalizaAgora(id) {
	    $.post("finalizaPedido", {'id' : id}, function(resposta) {
	      $("#pedido_"+id).html(resposta);
	    });
	  }  
  
  
//     function finalizaAgora(id) {
//       $.post("finalizaPedido", {'id' : id}, function() {
//         $("#pedido_"+id).html("Finalizado");
//       });
//     }
    
    

    
    $(document).ready(function() {
        $.ajax({
            url: "http://rest-service.guides.spring.io/greeting"
        }).then(function(data) {
           $('.greeting-id').append(data.id);
           $('.greeting-content').append(data.content);
        });
    });
    
    
  </script>
  

  <a href="novoPedido">Criar novo pedido</a>
  <br/><br/>

  <table>
  
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
  </tr>
  <c:forEach items="${pedidos}" var="pedido">
    <tr  id="pedido_${pedido.id}">
      <td>${pedido.id}</td>
      <td>${pedido.descricao}</td>
      
		<c:if test="${pedido.finalizado eq false}">
		  <td id="pedido_${pedido.id}">
		      <a href="#" onClick="finalizaAgora(${pedido.id})">
		      Finaliza agora!
		      </a>
		  </td>
		</c:if>      
      
      <c:if test="${pedido.finalizado eq true}">
        <td>Finalizado</td>
      </c:if>
      

      
      <td>
        <fmt:formatDate 
          value="${pedido.dataFinalizacao.time}" 
          pattern="dd/MM/yyyy"/>
      </td>
      
      
      <td><a href="removerPedido?id=${pedido.id}">Remover</a></td>
	  <td><a href="exibirPedido?id=${pedido.id}">Alterar</a></td>      
      
    </tr>
  </c:forEach>
  </table>
  <br><br>
  <table>
  <tr>
  <td>
  <div><input id="btReload" type="button" value="Atualizar página" /></div>
  
  </td>
  
  </tr>
  
  </table>
  
</body>
</html>