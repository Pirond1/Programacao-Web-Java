<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
	<h1>Produtos Cadastrados:</h1>
	<a href="CadastrarProduto.jsp" class="btn btn-success mb-3">Novo Produto</a>
	<table class="table table-bordered">
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