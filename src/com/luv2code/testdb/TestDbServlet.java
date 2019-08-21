package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set up connection variable
		String user = "springstudent";
		String password = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3305/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";// this is driver class name for jdbc driver for my sql

		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to database.." + jdbcUrl);

			Class.forName(driver);//this line initializes the driver 

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

			out.println("connection successful..");
			
			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
