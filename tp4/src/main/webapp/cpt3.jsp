<%@ page import="fr.but3.Counter" %>
<html>

<body>
	
	<%! Counter counter = new Counter(); %>

	<% counter.incr(); %>
	<% out.println(counter.toString()); %>
</body>

</html>