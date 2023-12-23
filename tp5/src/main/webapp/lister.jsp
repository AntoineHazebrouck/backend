<%@ page
	import="fr.but3.model.Auteur, jakarta.persistence.EntityManagerFactory, jakarta.persistence.EntityManager, jakarta.persistence.Persistence"
	%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset='utf-8'>
		<meta http-equiv='X-UA-Compatible' content='IE=edge'>
		<title>Page Title</title>
		<meta name='viewport' content='width=device-width, initial-scale=1'>
		<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
		<script src='main.js'></script>
	</head>

	<body>
		<%! EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence-unit"); EntityManager
			entityManager=emf.createEntityManager(); %>
			<% Auteur auteur=entityManager.find(Auteur.class, 1); %>
				<% out.println(auteur); %>

	</body>

	</html>