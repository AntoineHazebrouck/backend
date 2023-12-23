package jez;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class Select extends HttpServlet {

	private Connection connection;

	@Override
	public void init() throws ServletException {
		super.init();
		String url =
				"jdbc:postgresql://90.110.246.238/spring?user=postgres&password=postgres&ssl=false";
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {

			Statement statement;
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM etudiants;");



			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>" + "Test" + "</title>");
			out.println("<body>");

			while (result.next()) {
				out.println(result.getString("name"));
			}

			out.println("""
					<h1>Inserer un etudiant</h1>

					<form action="http://localhost:8080/tp1/insert" method="post">
						<label for="name">Name:</label><br>
						  <input type="text" id="name" name="name"><br>
					</form>
						""");
			out.println("</body>");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
