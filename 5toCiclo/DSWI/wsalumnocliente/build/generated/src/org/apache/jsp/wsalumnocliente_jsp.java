package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wsalumnocliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ALUMNO CLIENTE</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>DIME QUE APROBE POR FAVOR!!!</h1>\n");
      out.write("        <form action=\"wsalumnocliente.jsp\" method=\"POST\">\n");
      out.write("            Alumno:<input type=\"text\" name=\"txtalumno\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            Carrera:<select name=\"cmbcarrera\"><br><br>\n");
      out.write("                <option>programacion</option>\n");
      out.write("                <option>redes</option>\n");
      out.write("                <option>web</option>\n");
      out.write("                <option>office</option>\n");
      out.write("            </select>\n");
      out.write("            Turno:<select name=\"cmbturno\"><br><br>\n");
      out.write("                <option>mañana</option>\n");
      out.write("                <option>tarde</option>\n");
      out.write("                <option>noche</option>\n");
      out.write("            </select>\n");
      out.write("            Practica:<input type=\"text\" name=\"txtpractica\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            Participacion:<input type=\"text\" name=\"txtparticipacion\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            Examen: <input type=\"text\" name=\"txtexamen\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Estado?\" /><br><br>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("            ");
      out.write("<hr/>\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    ");
      out.write("<hr/>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
