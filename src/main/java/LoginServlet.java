

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	Connection con;

	public void init() throws ServletException {	
		
		try { //1st step loading the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/week5_jaimaica";
			String uname = "root";
			String pass= "navarr0Jds1..";
			
			this.con = DriverManager.getConnection(dburl, uname, pass);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("http://www.google.com");
		
		RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		rd.forward(request, response);
		
		System.out.println("execute code after redirect");
		
		PrintWriter out = response.getWriter();
		
		try {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			String insertSql = "INSERT INTO login VALUES(?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insertSql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, email);
			
			pst.executeUpdate();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM login");
			
			rs.next();
			
			response.setContentType("text/html");
			
			out.println("<table border=\"1\">"
					+ "<thead>"
					+ "<th>User Name</th>"
					+ "<th>Password</th>"
					+ "<th>Email</th>"
					+ "</thead>");
			
			while(rs.next()) {
				    out.println("<tr>"
					+ "<td>"+ rs.getString("username") + "</td>"
					+ "<td>"+ rs.getString("password") + "</td>"
					+ "<td>"+ rs.getString("email") + "</td>"
					+ "</tr>");
			}
					
			out.println("</table>");
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy()  {
		
		try {
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
