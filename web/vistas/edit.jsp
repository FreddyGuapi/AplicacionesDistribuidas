
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              PersonaDAO dao=new PersonaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
             
              Producto p=(Producto)dao.list(id);
          %>
            <h1>Modificar Producto</h1>
            <form action="Controlador">
                Nombre:<br>
                <input class="form-control" type="text" name="txtNombre" value=""><br>
                Precio: <br>
                <input class="form-control" type="text" name="txtPrecio" value=""><br>
                
                <input type="hidden" name="txtid" value="<%= p.getNombre()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
