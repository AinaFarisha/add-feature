// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*; 


// Extend HttpServlet class
public class changePassProcess extends HttpServlet {
	   
	   private boolean login=false;
	   private Statement statement=null;
	   private Connection connection = null;
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
	   String id=request.getParameter("userID");
	   String pw=request.getParameter("newPass");
	   String cpw=request.getParameter("confirmPass");
	   
	   if(pw.equals(cpw)) {
	  
	

      // Set response content type
      response.setContentType("text/html");
  
      try{
    	  Class.forName("com.mysql.jdbc.Driver");

    	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useTimezone=true&serverTimezone=UTC", "root", "12345");	
    	  	
    	  		// Create a statement to retrieve objects
    	  		statement = connection.createStatement();        
    	  		
    	  		// update results to the table 
    	  		int stmt= statement.executeUpdate("Update student set password='"+ pw + "' where idstudent='" + id +"'");
    	  		
    	  	    	login = true;
    	  		}
      
      catch(Exception e) {
    	  System.out.println(e.getMessage());
     }
	   
	   
      if (login) {
    	  PrintWriter out = response.getWriter();
          String title = "Change Password Success";
          String docType =
             "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
          
          out.println(docType +
                  "<html>\n" +
                     "<head><title>" + title + "</title></head>\n" +
                     "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<form action=\"login.jsp\">" +
                        "<label>Login again with your new password to see student info!</label>" +
                        "<input type=\"submit\" value=\"Login\">" +
                        "</form>" +
                     "</body>" +
                  "</html>"
               );
      }
	   
	   }
	   else {
		   
		   PrintWriter out = response.getWriter();
	          String title = "fail to change pass";
	          String docType =
	             "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	          
	          out.println(docType +
	                  "<html>\n" +
	                     "<body bgcolor = \"#f0f0f0\">\n" +
	                      "Opps.. your Password did not match. Please try <a href=\"javascript:history.go(-1)\">again</a>" +
	                     "</body>" +
	                  "</html>"
	               );
	   }

    
   }
}

