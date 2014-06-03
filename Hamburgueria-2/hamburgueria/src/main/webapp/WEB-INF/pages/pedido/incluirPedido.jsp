<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
  <h3>Incluir pedido</h3>
  <form action="incluir" method="post">

    <input type="hidden" name="id" value="${pedido.id}" />
  
    <label>Descrição:</label><br>
    <input type="text" name="descricao" size="50" maxlength="50" value="${pedido.descricao}"><br>
    
    <label>Número da mesa:</label><br>
    <input type="text" name="numMesa" size="6" maxlength="3" value="${pedido.numMesa}"><br>

<!-- 

    <label>Finalizado?</label><input type="checkbox" name="finalizado" 
      value="true" ${pedido.finalizado? 'checked' : '' }/> <br>      

    <label>Data de finalização:</label><br>
    <input type="text" name="dataFinalizacao" 
      value="<fmt:formatDate 
      value="${pedido.dataFinalizacao.time}" 
      pattern="dd/MM/yyyy" />"/> 
    <br>


 -->
    
    
    <label>Produtos:</label>

   	<select name="produto">
	     <c:forEach items="${produtos}" var="produto">
			<option>
				<c:out value="${produto.id}"></c:out>			
			</option>	     		
	     </c:forEach>
   	</select>
  	<br>
    <input type="submit" value="Incluir"/>
  </form>
</body>
</html>