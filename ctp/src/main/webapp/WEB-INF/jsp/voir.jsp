<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>

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

