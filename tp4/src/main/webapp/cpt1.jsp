<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<html>

<body>
	<%! AtomicInteger counter = new AtomicInteger(0); %>
		
	<%
		counter.incrementAndGet();
	 %>

	 <% out.println(counter.toString()); %>
</body>

</html>