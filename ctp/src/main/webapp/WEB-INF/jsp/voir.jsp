<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<html lang="fr">
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Voir</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
</head>
<body class="container text-center">

	<header class="row">
		<h1>
			<%= request.getAttribute("username") %>
		</h1>
	</header>
	
	<div class="row align-items-center h-100">
			
		<div class="col-10 card mx-auto">
			
			<H1 class="my-5"> <%= ((Question) request.getAttribute("currentQuestion")).getLibquest() %></H1>

			
			<ul class="list-group">
				<% for (var choixObj : (List) request.getAttribute("choix")) { Choix choix=(Choix) choixObj; %>
					<li class="list-group-item"><%= choix.getLibchoix() %> -> <%= choix.getNbchoix() %> votes</li>
					
				<% } %>
			</ul>

			<h3 class="my-5">Il y a <%= request.getAttribute("percentage") %> de bonnes réponses </h3>
			<a class="btn btn-primary my-3" href="activer">Retour vers activer</a>
		</div>
	</div>



	
</body>
</html>