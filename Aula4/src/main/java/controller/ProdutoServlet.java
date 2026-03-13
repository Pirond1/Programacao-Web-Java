package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import model.Produto;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdutoServlet() {
        super();
    }
    
    ArrayList<Produto> lista = new ArrayList<>();

    public void init() {
		lista.add(new Produto(1, "Mouse", 100.00));
		lista.add(new Produto(2, "Monitor", 300.00));
		lista.add(new Produto(3, "Teclado", 200.00));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Minha_Lista", lista);
		request.getRequestDispatcher("Produto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		boolean existe = false;
		
		for (Produto p : lista) {
			if (p.getId() == id) {
				existe = true;
				break;
			}
		}
		
		if (existe) {
			request.setAttribute("ERRO", "ID já cadastrado!");
			request.getRequestDispatcher("CadastrarProduto.jsp").forward(request, response);
			return;
		}
		
		Produto novo = new Produto(id, nome, preco);
		lista.add(novo);
		
		response.sendRedirect("produtos");
	}

}
