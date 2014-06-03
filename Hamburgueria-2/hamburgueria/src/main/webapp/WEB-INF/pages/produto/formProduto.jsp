<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>

<body>

<div>

  <h3>Cadastrar produto</h3>
  <form action="incluirProduto" method="post">

    <input type="hidden" name="id" value="${produto.id}" />
  
    <label>Nome: </label><br>
    <input type="text" name="nome" size="60" value="${produto.nome}"><br>

    <label>Descrição:</label><br>
    <input type="text" name="descricao" size="60" value="${produto.descricao}"><br>

  	<label>Valor:</label><br>
  	<input type="number" name="preco" size="18" value="${produto.preco}"><br>
  
    <form:errors path="produto.nome" cssStyle="color:red"/><br/>
    
    <input type="submit" value="Cadastrar"/>
  </form>

</div>
</body>
</html>