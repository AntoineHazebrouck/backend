<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<html lang="fr">
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Voir</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
	<h1>
		<% out.println(((Question) request.getAttribute("currentQuestion")).getLibquest()); %>
	</h1>
	<ul>
		<% for (var choixObj : (List) request.getAttribute("choix")) { Choix choix=(Choix) choixObj; 
			out.println("<li>%s -> %s</li>".formatted(choix.getLibchoix(), choix.getNbchoix()));

			}
			%>
	</ul>

	<h3>
		Il y a 
		<% out.println( request.getAttribute("percentage")); %>
		de bonnes réponses
	</h3>

	<a href="activer">activer</a>
</body>
</html>