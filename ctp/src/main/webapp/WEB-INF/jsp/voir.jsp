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
			
			<H1 class="my-5"> <%= ((Question) request.getAttribute("currentQuestion")).getLibquest() %></H1>

			
			<ul class="list-group">
				<% for (var choixObj : (List) request.getAttribute("choix")) { Choix choix=(Choix) choixObj; %>
					<li class="list-group-item"><%= choix.getLibchoix() %> -> <%= choix.getNbchoix() %> votes</li>
					
				<% } %>
			</ul>

			<h3 class="my-5">Il y a <%= request.getAttribute("percentage") %> de bonnes réponses </h3>

			<div class="row">
				<div class="col">
					<a class="btn btn-primary my-3" href="activer">Retour vers activer</a>
				</div>
				<div class="col">
					<a class="btn btn-primary my-3" href="logout">Logout</a>
				</div>
			</div>
		</div>
	</div>



	
</body>
</html>