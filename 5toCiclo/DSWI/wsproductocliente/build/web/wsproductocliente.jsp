<%-- 
    Document   : wsproductocliente
    Created on : 26-sep-2024, 3:08:39
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTE PRODUCTO</title>
    </head>
    <body>
        <h1>PRECIO TOTAL DE UN PRODUCTO</h1>
        <form action="wsproductocliente.jsp" method="POST">
            Articulo:<input type="text" name="txtarticulo" value="" size="40"/><br><br>
            Precio de Compra:<input type="text" name="txtpc" value="" size="40" /><br><br>
            Linea del Articulo:<select name="cmblinea">
                <option>abarrotes</option>
                <option>ferreteria</option>
                <option>licores</option>
                <option>perfumes</option>
                <option>artefactos</option>                
            </select><br><br>
            Servicios Adicionales:<select name="cmbservicios">
                    <option>flete</option>
                    <option>mantenimiento</option>
                    <option>seguro</option>
                </select><br><br>
                <input type="submit" value="Consultar" /><br><br>
        </form>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsproducto.Wsproducto_Service service = new wsproducto.Wsproducto_Service();
	wsproducto.Wsproducto port = service.getWsproductoPort();
	 // TODO initialize WS operation arguments here
	java.lang.String articulo = request.getParameter("txtarticulo");
	double precioCompra = Float.parseFloat(request.getParameter("txtpc"));
	java.lang.String linea = request.getParameter("cmblinea");
	java.lang.String servAdicional = request.getParameter("cmbservicios");
	// TODO process result here
	java.lang.String result = port.wscalcprecio(articulo, precioCompra, linea, servAdicional);
        out.println("<br>Articulo: " + articulo);
        out.println("<br>Precio de Compra " + precioCompra);
        out.println("<br>Linea de Producto: " + linea);
        out.println("<br>Servicio Adicional: " + servAdicional);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
