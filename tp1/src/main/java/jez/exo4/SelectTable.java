package jez.exo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select-table")
public class SelectTable extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String tableName = request.getParameter("tableName").toString();

		try {
			Connection connection = DriverManager.getConnection(Database.url);

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM %s;".formatted(tableName));



			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>" + "Test" + "</title>");
			out.println("<body>");


			printStuff(result, out);

			// out.println("""
			// <h1>Inserer un etudiant</h1>

			// <form action="http://localhost:8080/tp1/insert" method="post">
			// <label for="name">Name:</label><br>
			// <input type="text" id="name" name="name"><br>
			// </form>
			// """);
			out.println("</body>");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printStuff(ResultSet result, PrintWriter out) throws SQLException {
		int nbColums = result.getMetaData().getColumnCount();

		for (int i = 1; i <= nbColums; i++) {

			out.println(result.getMetaData().getColumnName(i));
		}

		while (result.next()) {
			for (int i = 1; i <= nbColums; i++) {
				out.println(result.getString(i));
			}
		}
	}
}
