import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class passLogin extends HttpServlet {
	
	private boolean login=false;
	private Statement statement=null;
	private Connection connection = null;
	
	
	
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		  
		  String id=request.getParameter("ID");
		  
		  
		  //connect to database
	      try{
	    	  Class.forName("com.mysql.cj.jdbc.Driver");

	    	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useTimezone=true&serverTimezone=UTC", "root", "12345");	
	    	  	
	    	  		// Create a statement to retrieve objects
	    	  		statement = connection.createStatement();        

	    	  		String sql = "select name from Student where idstudent='"+ id +"'";
	    	  		
	    	  		
	    	  		// Retrieve results from the table
	    	  		ResultSet rs = statement.executeQuery(sql); 
	    	  		
	    	  		
	    	  		if(rs.next()) {
	    	  	    	login = true;
	    	  	    	
	    	  	    	
	    	  	    } 
	    	  		}
	    	  catch(Exception e) {
	    	  	   e.getMessage();
	    	  	}
	      
	      //valid id
	      if (login){
	    	  
	 

		      PrintWriter out = response.getWriter();
		      String title = "Password login";
		      String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		         
		      try {
		    	  
		    	  statement = connection.createStatement();
  	  		      ResultSet rs = statement.executeQuery("select name from Student where idstudent=" + id);
  	  	    	  String name=null;
  	  		      while(rs.next()) {
  	  		       name= rs.getString("name");
  	  		      }
		    	  
				out.println(docType +
				     "<html>\n" +
				        "<head><title>" + title + "</title></head>\n" +
				        "<body bgcolor = \"#f0f0f0\"><center>\n" +
				           "<h1 align = \"center\">" + title + "</h1>\n" +
				           "\n" +
				           "<form action=\"loginInfo\" method = \"GET\"><b>Your name</b>: "
				              + name + "\n <br/>\r\n"
				              		+ "	<br/>" +
				              "<b>User ID</b>: "
				              + "<input id=\"userID\" type=\"text\" name=\"userID\" value=\""+ request.getParameter("ID") +"\" readonly>" + "\n <br/>\r\n"
				              		+ "	<br/>" +
				              "<label for=\"pw\">Password: </label>\r\n"
				              + "	<input id=\"pw\" type=\"password\" name=\"pw\" value=\"\">\r\n"
				              + "	<br/>\r\n"
				              + "	<br/> "
				              + "\n" +
				              "<input type=\"submit\" value=\"Login\"> <a href=\"forgotPassword\"> Forgot Password?</a> </form>" +
				        "</center></body>" +
				     "</html>"
				  );
			
		      } catch (SQLException e) {
				System.out.print("failed");
			}
	    	  
	      }
	      
	      else {
	    	  System.out.print("failed2");
	      }
		      
		    
 }
}
