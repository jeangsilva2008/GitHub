<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>

<script src="<c:url value="//code.jquery.com/jquery-1.10.2.js" />"></script>

<script>
$(document).ready(function() {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});
</script>

</head>


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