package jez;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class Insert extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("http://localhost:8080/tp1/insert.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {

			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO etudiants VALUES ('%s');".formatted(req.getParameter("name").toString()));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("http://localhost:8080/tp1/select");
	}


}
