<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo Produto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
	<h1>Cadastrar Produtos</h1>
	<form action="produtos" method="post">
	<%
		String erro = (String)request.getAttribute("ERRO");
		if (erro != null){
	%>
		<div class="alert alert-danger">
			<%= erro %>
		</div>
	<% } %>
		<div class="mb-3">
		<label>ID</label>
		<input type="number" name="id" class="form-control" required>
		</div>
		<div class="mb-3">
			<label>Nome</label>
			<input type="text" name="nome" class="form-control" required>
		</div>
		<div class="mb-3">
			<label>Preço</label>
			<input type="number" step="0.01" name="preco" class="form-control" required>
		</div>
		
		<button type="submit" class="btn btn-primary">Cadastrar</button>
		<a href="produtos" class="btn btn-secondary">Voltar</a>
	</form>
</body>
</html>