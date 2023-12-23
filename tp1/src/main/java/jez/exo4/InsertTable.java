package jez.exo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert-table")
public class InsertTable extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String tableName = request.getParameter("tableName").toString();

		try {

			Connection connection = DriverManager.getConnection(Database.url);

			Statement statement = connection.createStatement();
			ResultSetMetaData metaData =
					statement.executeQuery("SELECT * FROM %s;".formatted(tableName)).getMetaData();

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>" + "Insert data" + "</title>");
			out.println("<body>");

			out.println("<h1>Insert data</h1>");
			out.println(
					"<form action=\"http://localhost:8080/tp1/insert-table?tableName=%s\" method=\"post\">"
							.formatted(tableName));

			for (int i = 1; i <= metaData.getColumnCount(); i++) {

				String columnName = metaData.getColumnName(i);
				out.println("<label for=\"%s\">%s:</label><br>".formatted(columnName, columnName));
				out.println("<input type=\"text\" id=\"%s\" name=\"%s\"><br>".formatted(columnName,
						columnName));
			}

			out.println("<input type=\"submit\">");

			out.println("</form>");

			out.println("</body>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tableName = request.getParameter("tableName");

		try {
			Connection connection = DriverManager.getConnection(Database.url);

			Statement statement = connection.createStatement();
			String sql = "INSERT INTO %s %s VALUES %s;".formatted(tableName,
					buildColumns(request.getParameterMap()),
					buildValues(request.getParameterMap(), tableName));

			System.out.println(sql);
			statement.executeUpdate(sql);

			// // TODO

			// ResultSetMetaData metaData =
			// statement.executeQuery("SELECT * FROM %s;".formatted(tableName)).getMetaData();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String buildValues(Map<String, String[]> parameterMap, String tableName) {
		String sqlValues = "(";
		for (var value : parameterMap.values()) {
			if (!value[0].equals(tableName)) {
				sqlValues += "'%s', ".formatted(value[0]);
			}
		}
		return (sqlValues + ")").replace(", )", ")");
	}

	private String buildColumns(Map<String, String[]> parameterMap) {
		String sqlColums = "(";
		for (var value : parameterMap.keySet()) {
			if (!value.equals("tableName")) {
				sqlColums += value + ", ";
			}
		}
		return (sqlColums + ")").replace(", )", ")");
	}

}
