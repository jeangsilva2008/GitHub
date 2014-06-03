<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
  <h3>Incluir pedido - ${pedido.id}</h3>
  <form action="alterarPedido" method="post">

    <input type="hidden" name="id" value="${pedido.id}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">
      ${pedido.descricao}
    </textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${pedido.finalizado? 'checked' : '' }/> <br />      

    Data de finalização: <br />
    <input type="text" name="dataFinalizacao" 
      value="<fmt:formatDate 
      value="${pedido.dataFinalizacao.time}" 
      pattern="dd/MM/yyyy" />"/> 
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>