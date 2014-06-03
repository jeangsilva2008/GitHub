<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
  <h3>Cadastrar produto</h3>
  <form action="cadastrarProduto" method="post">

    <input type="hidden" name="id" value="${produto.id}" />
  
    Nome:<br />
    <textarea name="nome" cols="100" rows="5">
      ${produto.nome}
    </textarea>
    <br />      
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">
      ${produto.descricao}
    </textarea>
    <br />
  	Valor:<br>
	<fmt:formatNumber value="${produto.preco}" type="currency"/>  
  
    <input type="submit" value="Cadastrar"/>
  </form>
</body>
</html>