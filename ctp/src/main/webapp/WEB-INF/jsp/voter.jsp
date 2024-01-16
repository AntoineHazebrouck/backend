<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<html lang="fr">
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Voter</title>
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