<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
<html lang="fr">
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Voter</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
	<h1>
		<% out.println(((Question) request.getAttribute("currentQuestion")).getLibquest()); %>
	</h1>
	<form method="POST" action="/voter">
		<% for (var choixObj : (List) request.getAttribute("choix")) { Choix choix=(Choix) choixObj; out.println("<input ");
			out.println(" <type=");
			out.println(" \"radio\""); out.println("<input type=\"radio\" ");
				out.println(" name=\"my_choix\" ");
				out.println(" id=\" %s\" ".formatted(choix.getCno()));
				out.println(" value=\" %s\" ".formatted(choix.getCno()));
				out.println(">");

			out.println("<label for=\"%s\">%s</label><br>".formatted(choix.getCno(), choix.getLibchoix()));

			}
			%>
			<input type="submit" value="Submit">
	</form>
</body>
</html>