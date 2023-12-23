<html>

<body>
	
	<%!
		class Counter
		{
			private int val = 0;
			
			public int intValue()
			{
				return val;
			}
			
			public String toString()
			{
				return "" + val;
			}

			public void incr()
			{
				val++;
			}
		}
	%>
	<%! Counter counter = new Counter(); %>

	<% counter.incr(); %>
	<% out.println(counter.toString()); %>
</body>

</html>