package sevlet2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Formulario() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
		PrintWriter pw = response.getWriter();
		
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
		pw.write("<title>Formulário</title>");
		pw.write("</head>");
		pw.write("<body>"); 
		pw.write("Informe seu Nome");
		pw.write("<br/>");
		pw.write("<form action='Dados' method='post' >");
		pw.write("<input type='text' name='Nome' />"); 
		pw.write("<input type='submit' value='Confirmar' />");
		pw.write("</form>");
		pw.write("</body>");
		pw.write("</html>");

	}
}
