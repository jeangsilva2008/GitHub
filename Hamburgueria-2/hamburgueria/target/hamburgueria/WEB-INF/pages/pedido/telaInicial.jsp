<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>
  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
  
  <script type="text/javascript">
  

        
    $(document).ready(function() {
        $.ajax({
            url: "http://localhost:8080/hamburgueria-2/pedido"
        }).then(function(data) {
           $('.greeting-id').append(pedido.id);
           $('.greeting-content').append(pedido.descricao);
        });
    });
    
    
  </script>
  

</body>
</html>