<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>

	<h1>Produtos Cadastrados:</h1>
	<table border=1>
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Preço</th>
	</tr>
	<%
		ArrayList<Produto> lista = (ArrayList<Produto>)request.getAttribute("Minha_Lista");
		if (lista != null){
			for (Produto p : lista){
	%>
	<tr>
		<td><%=p.getId() %></td>
		<td><%=p.getNome() %></td>
		<td>R$<%=p.getPreco() %></td>
	</tr>
	<% }} %>
	</table>

</body>
</html>