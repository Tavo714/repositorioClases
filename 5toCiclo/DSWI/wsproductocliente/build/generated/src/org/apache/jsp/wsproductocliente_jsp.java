package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wsproductocliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>CLIENTE PRODUCTO</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>PRECIO TOTAL DE UN PRODUCTO</h1>\n");
      out.write("        <form action=\"wsproductocliente.jsp\" method=\"POST\">\n");
      out.write("            Articulo:<input type=\"text\" name=\"txtarticulo\" value=\"\" size=\"40\"/><br><br>\n");
      out.write("            Precio de Compra:<input type=\"text\" name=\"txtpc\" value=\"\" size=\"40\" /><br><br>\n");
      out.write("            Linea del Articulo:<select name=\"cmblinea\">\n");
      out.write("                <option>abarrotes</option>\n");
      out.write("                <option>ferreteria</option>\n");
      out.write("                <option>licores</option>\n");
      out.write("                <option>perfumes</option>\n");
      out.write("                <option>artefactos</option>                \n");
      out.write("            </select><br><br>\n");
      out.write("            Servicios Adicionales:<select name=\"cmbservicios\">\n");
      out.write("                    <option>flete</option>\n");
      out.write("                    <option>mantenimiento</option>\n");
      out.write("                    <option>seguro</option>\n");
      out.write("                </select><br><br>\n");
      out.write("                <input type=\"submit\" value=\"Consultar\" /><br><br>\n");
      out.write("        </form>\n");
      out.write("            ");
      out.write("<hr/>\n");
      out.write("    ");

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
