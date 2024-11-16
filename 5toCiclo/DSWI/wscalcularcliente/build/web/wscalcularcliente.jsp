<%-- 
    Document   : wscalcularcliente
    Created on : 26-sep-2024, 0:23:34
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTE CALCULADORA</title>
    </head>
    <body>
        <h1>HAZME LA TAREA Y CALCULA MI FORMULA!!!</h1>
        <form action="wscalcularcliente.jsp" method="POST">
            X:<input type="text" name="txtx" value="" size="40"/><br><br>
            a:<input type="text" name="txta" value="" size="40"/><br><br>
            b:<input type="text" name="txtb" value="" size="40"/><br><br>
            c:<input type="text" name="txtc" value="" size="40"/><br><br>
            t:<input type="text" name="txtt" value="" size="40"/><br><br>
            <input type="submit" value="Calcular!" />
        </form>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wscalcular.Wscalcular_Service service = new wscalcular.Wscalcular_Service();
	wscalcular.Wscalcular port = service.getWscalcularPort();
	 // TODO initialize WS operation arguments here
	double r = 0.0d;
	double x = Float.parseFloat(request.getParameter("txtx"));
	double a = Float.parseFloat(request.getParameter("txta"));
	double b = Float.parseFloat(request.getParameter("txtb"));
	double c = Float.parseFloat(request.getParameter("txtc"));
	double t = Float.parseFloat(request.getParameter("txtt"));
	// TODO process result here
	java.lang.Double result = port.calcular(r, x, a, b, c, t);
	out.println("La formula con los parametros ingresados resulta = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
