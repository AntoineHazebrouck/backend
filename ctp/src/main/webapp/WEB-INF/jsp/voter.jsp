<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="fr">
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Voter</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
</head>
<body class="container text-center">
	
	<header class="row align-items-center">
		<div class="col">
			<h1>
				<%= request.getAttribute("username") %>
			</h1>
		</div>
		<div class="col">
			<img class="mt-5"
				src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Logotype_Universit%C3%A9_de_Lille_2022.svg/2560px-Logotype_Universit%C3%A9_de_Lille_2022.svg.png"
				width="200"
				alt="logo-univ-lille">
		</div>


	</header>

	<div class="row align-items-center h-100">
			
		<div class="col-10 card mx-auto">
			<H1 class=""> <%= ((Question) request.getAttribute("currentQuestion")).getLibquest() %></H1>

			<form method="POST" action="/voter">
				<% for (var choixObj : (List) request.getAttribute("choix")) { Choix choix=(Choix) choixObj; %>
					
					<div class="form-group">
						<input class="form-check-input" type="radio" name="my_choix" id="<%= choix.getCno() %>" value="<%= choix.getCno() %>">
						<label class="form-check-label" for="<%= choix.getCno() %>"><%= choix.getLibchoix() %></label><br>
					</div>
					
					<% } %>
						<button class="btn btn-primary" type="submit">Répondre</button>
			</form>
		</div>
	</div>

</body>
</html>