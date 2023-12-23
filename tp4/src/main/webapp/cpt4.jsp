<%@ page import="fr.but3.Counter" %>
<html>

<body>
	<jsp:useBean id="counter" class="fr.but3.Counter" scope="application"/>

	<% counter.incr(); %>
	<% out.println(counter.toString()); %>
</body>

</html>