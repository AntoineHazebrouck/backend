package jez.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/compteur")
public class Compteur extends HttpServlet {
	private AtomicInteger globalCount = new AtomicInteger(0);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String countIdentifier = "count";

		if (request.getSession().getAttribute(countIdentifier) == null) {
			request.getSession().setAttribute(countIdentifier, 1);
		}
		Object userCountItem = request.getSession().getAttribute(countIdentifier);

		int userCount = Integer.parseInt(userCountItem.toString());
		globalCount.incrementAndGet();
		request.getSession().setAttribute(countIdentifier, userCount + 1);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");
		out.println("<title>" + "Test" + "</title>");
		out.println("<body>");

		out.println("<h1>");
		out.println("""
					Vous avez accédé %s fois à cette page sur les %s accès au total
				""".formatted(userCountItem, globalCount));

		out.println("</h1>");

		out.println("</body>");
		out.println("</html>");

	}

}
