package jez.filters;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({"/*"})
public class MyRequestFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println(LocalDate.now());
		System.out.println(request.getRequestURL());
		chain.doFilter(request, response);
	}
}
