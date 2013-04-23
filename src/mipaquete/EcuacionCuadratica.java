package mipaquete;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/eq")
public class EcuacionCuadratica extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
   {
		RequestDispatcher rd = request.getRequestDispatcher("ecuacion.html");
		rd.forward(request, response);
   }
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ecuacion CUadratica</title>");
        out.println("<script language='javascript'>");
        out.println("function onsbmt(){ if(isNaN(document.getElementById('a').value)){ alert('algun parametro es no numerico!!');return false;} if(isNaN(document.getElementById('b').value)){ alert('algun parametro es no numerico!!');return false;} if(isNaN(document.getElementById('c').value)){ alert('algun parametro es no numerico!!'); return false;} return true;}");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        if(request.getParameter("a").length()>0 && request.getParameter("b").length()>0 && request.getParameter("c").length()>0)
        {    
         out.println("<form id='myfrm' action='/ecuaciones/eq' method='post'>");
 	     out.println("<label> Valor de a:</label><input name='a' id='a' type='text' class='onlynum' value='"+request.getParameter("a")+"'/><br/>");
 	     out.println("<label> Valor de b:</label><input name='b' id='b' type='text' class='onlynum' value='"+request.getParameter("b")+"'/><br/>");
 	     out.println("<label> Valor de c:</label><input name='c' id='c' type='text' class='onlynum' value='"+request.getParameter("c")+"'/><br/><input type='submit' onclick='return onsbmt();'/>");
 	     out.println("</form>");
 	     double a = 0.0,b = 0.0,c = 0.0;
 	     a = Double.parseDouble(request.getParameter("a"));
    	 b = Double.parseDouble(request.getParameter("b"));
    	 c = Double.parseDouble(request.getParameter("c"));
    	 double temp = (b * b) - (4 * a * c);
    	 double tmp = 2 * a;
    	 if(tmp == 0.0)
    	  out.println("<h1>la ecuacion tiene infinitas soluciones!</h1>");
    	 else
    	 {
    	     if(temp < 0.0)
    		  out.println("<h1>la ecuacion no tiene soluciones reales!</h1>");
    	     else if(temp > 0.0)
    		  out.println("<h1>soluciones:</h1><p>x1:"+((-b+Math.sqrt(temp))/ tmp)+",x2:"+((-b - Math.sqrt(temp))/ tmp)+"</p>");
    	     else
    		  out.println("<h1>solucion unica:</h1><p>x1:"+(-b / (2 * a))+"</p>");
    	 }
       }
       else
       {
    	   out.println("algun parametro faltaba");	
       }
       out.println("</body>");
       out.println("</html>");
    }
}
