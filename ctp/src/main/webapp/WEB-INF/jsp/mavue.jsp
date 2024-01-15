<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>
	<H1>Liste des questions</H1>

	<form method="POST" action="/activer">
		<% for (var questionObj : (List) request.getAttribute("questions")) { Question question=(Question) questionObj;
			out.println("<input type=\"radio\" ");
			out.println(" name=\"my_question\" ");
			out.println(" id=\" %s\" ".formatted(question.getQno()));
			out.println(" value=\" %s\" ".formatted(question.getQno()));
			out.println(">");

			out.println("<label for=\"%s\">%s</label><br>".formatted(question.getQno(), question.getLibquest()));

			}
			%>
			<input type="submit" value="Submit">
	</form>