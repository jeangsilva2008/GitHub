<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
<style http-equiv="Content-Type">
body {
    font-family: "Lucida Grande", "Lucida Sans Unicode", Verdana, Arial, Helvetica, sans-serif;
    font-size: 12px;
}
p, h1, form, button {
    border: 0;
    margin: 0;
    padding: 0;
}
.spacer {
    clear: both;
    height: 1px;
}
.myform 
{
   
    margin: 0 auto;
    width: 400px;
    padding: 14px;
}
#stylized 
{
   
    border: solid 2px #b7ddf2;
    background: #ebf4fb;
}
#stylized h1 {
    font-size: 14px;
    font-weight: bold;
    margin-bottom: 8px;
}
#stylized p {
    font-size: 11px;
    color: #666666;
    margin-bottom: 20px;
    border-bottom: solid 1px #b7ddf2;
    padding-bottom: 10px;
}
#stylized label {
    display: block;
    font-weight: bold;
    text-align: right;
    width: 140px;
    float: left;
}
#stylized .small {
    color: #666666;
    display: block;
    font-size: 11px;
    font-weight: normal;
    text-align: right;
    width: 140px;
}
#stylized input, select {
    float: left;
    font-size: 12px;
    padding: 4px 2px;
    border: solid 1px #aacfe4;
    width: 200px;
    margin: 2px 0 20px 10px;
}
#stylized button {
    clear: both;
    margin-left: 150px;
    width: 246px;
    height: 31px;
    background: #666666 url(img/button.png) no-repeat;
    text-align: center;
    line-height: 31px;
    color: #FFFFFF;
    font-size: 11px;
    font-weight: bold;
}
</style>

</head>

<body>

<div>

  <h3>Cadastrar produto</h3>
  <form action="incluirProduto" method="post">

    <input type="hidden" name="id" value="${produto.id}" />
  
    <label>Nome: </label><br>
    <input type="text" name="nome" size="60" value="${produto.nome}"><br>

    <label>Descri��o:</label><br>
    <input type="text" name="descricao" size="60" value="${produto.descricao}"><br>

  	<label>Valor:</label><br>
  	<input type="number" name="preco" size="18" value="${produto.preco}"><br>
  
    <form:errors path="produto.nome" cssStyle="color:red"/><br/>
    
    <input type="submit" value="Cadastrar"/>
  </form>

</div>
</body>
</html>