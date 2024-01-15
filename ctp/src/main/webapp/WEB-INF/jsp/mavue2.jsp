<%@ page import="java.util.*,fr.but3.ctp.entities.*" %>

	<h1>
		<% out.println(((Question) request.getAttribute("currentQuestion")).getLibquest()); %>
	</h1>