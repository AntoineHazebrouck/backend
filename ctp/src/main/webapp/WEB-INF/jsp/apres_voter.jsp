<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<div class="col">
			<h1>Vous avez répondu : <%= ((Choix) request.getAttribute("choix")).getLibchoix() %> </h1>
			<a class="btn btn-primary my-3" href="logout">Logout</a>
		</div>
	</div>



	
</body>
</html>