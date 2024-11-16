package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wsdetmayorcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>DETERMINAR NUMERO MAYOR</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Ingrese los numeros!</h1>\n");
      out.write("        <form action=\"wsdetmayorcliente.jsp\" method=\"POST\">\n");
      out.write("            A:<input type=\"text\" name=\"txta\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            B:<input type=\"text\" name=\"txtb\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            C:<input type=\"text\" name=\"txtc\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            D:<input type=\"text\" name=\"txtd\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Mayor?\" /><br><br>\n");
      out.write("        </form>\n");
      out.write("            ");
      out.write("<hr/>\n");
      out.write("    ");

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
