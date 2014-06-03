<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<body>
  <h3>Alterar pedido - ${pedido.id}</h3>
  <form action="incluir" method="post">

    <input type="hidden" name="id" value="${pedido.id}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">
      ${pedido.descricao}
    </textarea>
    <br />      


    <label>Número da mesa:</label><br>
    <input type="text" name="numMesa" size="6" maxlength="3" value="${pedido.numMesa}"><br>
    
<!-- 
    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${pedido.finalizado? 'checked' : '' }/> <br />      

    Data de finalização: <br />
    <input type="text" name="dataFinalizacao" 
      value="<fmt:formatDate 
      value="${pedido.dataFinalizacao.time}" 
      pattern="dd/MM/yyyy" />"/> 

 -->
    <br>
  
    <label>Produtos:</label>

   	<select name="produto">
	     <c:forEach items="${pedido.itens}" var="item">
			<option>
				<c:out value="${item.id}"></c:out>			
			</option>	     		
	     </c:forEach>
   	</select>
  	<br>  
  
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>