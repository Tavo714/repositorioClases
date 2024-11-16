<%-- 
    Document   : ventas
    Created on : 25-sep-2024, 20:30:50
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Todo Barato</title>
    </head>
    <body>
        <h1>Registro de Productos</h1>
        <form action="ventas.jsp" method="POST">
            Producto:<input type="text" name="txtproducto" value="" size="40" /><br>
            Precio Compra:<input type="text" name="txtpc" value="" size="10" /><br>
            Margen Utilidad:<input type="text" name="txtmu" value="" size="10" /><br>
            <input type="submit" value="Enviar" />
        </form>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	ws.Wsventas_Service service = new ws.Wsventas_Service();
	ws.Wsventas port = service.getWsventasPort();
	 // TODO initialize WS operation arguments here
         String nom= request.getParameter("txtproducto");
	double preciocompra = Float.parseFloat(request.getParameter("txtpc"));
	double margenutilidad = Float.parseFloat(request.getParameter("txtmu"));
	// TODO process result here
	java.lang.Double result = port.precioventa(preciocompra, margenutilidad);
        out.println("<br>Producto: " + nom);
        out.println("<br>Precio de compra: "+preciocompra);
        out.println("<br>Margen de Utilidad: "+margenutilidad);
	out.println("<br><b>PRECIO DE VENTA CALCULADO ES = "+result+"</b>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
