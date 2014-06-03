
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<td>${pedido.id}</td>
<td>${pedido.descricao}</td>
<td>Finalizada</td>
<td>
  <fmt:formatDate value="${pedido.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
</td>
<td><a href="removeTarefa?id=${pedido.id}">Remover</a></td>
<td><a href="mostraTarefa?id=${pedido.id}">Alterar</a></td>
