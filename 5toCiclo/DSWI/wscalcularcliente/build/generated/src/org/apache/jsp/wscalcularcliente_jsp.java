package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wscalcularcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>CLIENTE CALCULADORA</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>HAZME LA TAREA Y CALCULA MI FORMULA!!!</h1>\n");
      out.write("        <form action=\"wscalcularcliente.jsp\" method=\"POST\">\n");
      out.write("            X:<input type=\"text\" name=\"txtx\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            a:<input type=\"text\" name=\"txta\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            b:<input type=\"text\" name=\"txtb\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            c:<input type=\"text\" name=\"txtc\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            t:<input type=\"text\" name=\"txtt\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Calcular!\" />\n");
      out.write("        </form>\n");
      out.write("            ");
      out.write("<hr/>\n");
      out.write("    ");

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
