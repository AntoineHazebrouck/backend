<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>

	<html lang="fr">

	<head>
		<meta charset='utf-8'>
		<meta http-equiv='X-UA-Compatible' content='IE=edge'>
		<title>Activer</title>
		<meta name='viewport' content='width=device-width, initial-scale=1'>
		<link rel='stylesheet' type='text/css' media='screen'
			href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
	</head>

	<body class="container text-center">

		<div class="row align-items-center h-100">
			
			<div class="col-10 card mx-auto">
				<H1 class="">Liste des questions</H1>
	
				<form method="POST" action="/activer">
					<% for (var questionObj : (List) request.getAttribute("questions")) { Question question=(Question)
						questionObj; %>
						
						<div class="form-group">
							<input class="form-check-input" type="radio" name="my_question" id="<%= question.getQno() %>" value="<%= question.getQno() %>">
							<label class="form-check-label" for="<%= question.getQno() %>"><%= question.getLibquest() %></label><br>
						</div>
						
						<% } %>
						<button class="btn btn-primary" type="submit">Activer</button>
				</form>
			</div>
		</div>

		


	</body>

	</html>