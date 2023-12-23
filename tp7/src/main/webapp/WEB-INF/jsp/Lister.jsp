<%@ page import="java.util.*" %>
	<H1>Liste etudiants</H1>

	<ul>
		<% for (var etudiant : (List) request.getAttribute("etudiants")) { out.println("<li>" + etudiant + "</li>"); }
			%>
	</ul>