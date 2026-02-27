package sevlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class Aula_HTTP
 */

@WebServlet("/ListaParametros")
public class Aula_HTTP extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aula_HTTP() {
        super();
        System.out.println("Construtor chamado");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	Enumeration<String> listaParametros = request.getParameterNames();
    	
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<body>");

        while (listaParametros.hasMoreElements()) {
        	String p = listaParametros.nextElement().toString();
        	String v = request.getParameter(p);

            if (!v.equals("")) {
            	pw.write("<span>"+p+" -> "+v+"</span>");
            	pw.write("<br/>");
            }
        }

        pw.println("</body>");
        pw.println("</html>");
    }
}