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

	<body class="container justify-content-center text-center">

			<H1 class="justify-content-center">Liste des questions</H1>
			
			<form method="POST" action="/activer" class="justify-content-center">
				<% for (var questionObj : (List) request.getAttribute("questions")) { 
					Question question=(Question)
					questionObj; out.println("<input type=\"radio\" ");
				out.println(" name=\"my_question\" ");
				out.println(" id=\" %s\" ".formatted(question.getQno()));
				out.println(" value=\" %s\" ".formatted(question.getQno()));
				out.println(">");
	
					out.println("<label for=\"%s\">%s</label><br>".formatted(question.getQno(), question.getLibquest()));
	
					}
					%>
					<input type="submit" value="Submit">
			</form>

		
	</body>

	</html>