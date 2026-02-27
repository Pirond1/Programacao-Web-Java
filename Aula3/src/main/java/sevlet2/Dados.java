package sevlet2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/Dados")
public class Dados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dados() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter pw = response.getWriter();

        pw.write("<html>");
        pw.write("<body>");
        pw.write("<h2>Parâmetros Recebidos:</h2>");

        Enumeration<String> parametros = request.getParameterNames();

        while (parametros.hasMoreElements()) {
            String p = parametros.nextElement();
            String v = request.getParameter(p);

            pw.write("<p>");
            pw.write("<strong>" + p + "</strong> : " + v);
            pw.write("</p>");
        }
        
		pw.write("<form action='Formulario' method='get' >");
		pw.write("<input type='submit' value='Retornar' />");
		pw.write("</form>");
		
        pw.write("</body>");
        pw.write("</html>");
    }

}
