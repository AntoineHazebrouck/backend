package fr.but3.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("verif")
public class Verif extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		Boolean authorized = true;
		if (!"antoine".equals(req.getParameter("login")))
		{
			authorized = false;
		}
		if (!"antoine".equals(req.getParameter("password")))
		{
			authorized = false;
		}


		if (authorized) {
			
		}
	}
}
