<%-- 
    Document   : wsdetmayorcliente
    Created on : 25-sep-2024, 22:22:45
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DETERMINAR NUMERO MAYOR</title>
    </head>
    <body>
        <h1>Ingrese los numeros!</h1>
        <form action="wsdetmayorcliente.jsp" method="POST">
            A:<input type="text" name="txta" value="" size="40"/><br><br>
            B:<input type="text" name="txtb" value="" size="40"/><br><br>
            C:<input type="text" name="txtc" value="" size="40"/><br><br>
            D:<input type="text" name="txtd" value="" size="40"/><br><br>
            <input type="submit" value="Mayor?" /><br><br>
        </form>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsdetmayor.Wsdetmayor_Service service = new wsdetmayor.Wsdetmayor_Service();
	wsdetmayor.Wsdetmayor port = service.getWsdetmayorPort();
	 // TODO initialize WS operation arguments here
	int a = Integer.parseInt(request.getParameter("txta"));
	int b = Integer.parseInt(request.getParameter("txtb"));
	int c = Integer.parseInt(request.getParameter("txtc"));
	int d = Integer.parseInt(request.getParameter("txtd"));
	int mayor = 0;
	// TODO process result here
	java.lang.Integer result = port.detmayor(a, b, c, d, mayor);
	out.println("El mayor de los numeros es = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
