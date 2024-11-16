<%-- 
    Document   : wsalumnocliente
    Created on : 26-sep-2024, 2:30:01
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALUMNO CLIENTE</title>
    </head>
    <body>
        <h1>DIME QUE APROBE POR FAVOR!!!</h1>
        <form action="wsalumnocliente.jsp" method="POST">
            Alumno:<input type="text" name="txtalumno" value="" size="40"/><br><br>
            Carrera:<select name="cmbcarrera"><br><br>
                <option>programacion</option>
                <option>redes</option>
                <option>web</option>
                <option>office</option>
            </select>
            Turno:<select name="cmbturno"><br><br>
                <option>mañana</option>
                <option>tarde</option>
                <option>noche</option>
            </select>
            Practica:<input type="text" name="txtpractica" value="" size="40"/><br><br>
            Participacion:<input type="text" name="txtparticipacion" value="" size="40"/><br><br>
            Examen: <input type="text" name="txtexamen" value="" size="40"/><br><br>
            <input type="submit" value="Estado?" /><br><br>

        </form>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsalumno.Wsalumno_Service service = new wsalumno.Wsalumno_Service();
	wsalumno.Wsalumno port = service.getWsalumnoPort();
	 // TODO initialize WS operation arguments here
	java.lang.String nombre = request.getParameter("txtalumno");
	java.lang.String carrera = request.getParameter("cmbcarrera");
	java.lang.String turno = request.getParameter("cmbturno");
	double practica = Float.parseFloat(request.getParameter("txtpractica"));
	double participacion = Float.parseFloat(request.getParameter("txtparticipacion"));
	double examen = Float.parseFloat(request.getParameter("txtexamen"));
	// TODO process result here
	java.lang.String result = port.wscalcprom(nombre, carrera, turno, practica, participacion, examen);
	out.println("<br>Alumno: " + nombre);
        out.println("<br>Carrera: " + carrera);
        out.println("<br>Turno: " + turno);
        out.println("<br>Practica: " + practica);
        out.println("<br>Participacion: " + participacion);
        out.println("<br>Examen: " + examen);
        out.println("<br>El alumno esta "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
