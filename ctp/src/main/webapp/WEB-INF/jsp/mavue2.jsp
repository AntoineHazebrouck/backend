<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>

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