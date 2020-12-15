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
	   
	   loginInfo obj=new loginInfo();
	   String id=obj.getId();
	   String pw=request.getParameter("newPass");
	   String cpw=request.getParameter("confirmPass");
	   PrintWriter out = response.getWriter();
      
       String docType =
          "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
       
	   
	   String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
	   boolean validPassword = isValidPassword(pw,regex);
	   
	   if(pw.equals(cpw)) {
		    
		   if(validPassword) {
	  
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
    	  
          String title = "Change Password Success";
          
          
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
		   String title = "fail to change pass";
		   
	          out.println(docType +
	                  "<html>\n" +
	                     "<body bgcolor = \"#f0f0f0\">\n" +
	                      "Your password must be 8 or more character and contain uppercase, lowercase, number and special character(@,#,$,%,_). Please try <a href=\"javascript:history.go(-1)\">again</a>" +
	                     "</body>" +
	                  "</html>"
	               );
		  
	   }

	   } else {
		   String title = "fail to change pass";
		   
	          out.println(docType +
	                  "<html>\n" +
	                     "<body bgcolor = \"#f0f0f0\">\n" +
	                      "Opps.. your Password did not match. Please try <a href=\"javascript:history.go(-1)\">again</a>" +
	                     "</body>" +
	                  "</html>"
	               );
	   }
   }
   

private boolean isValidPassword(String password, String regex) {
	// TODO Auto-generated method stub
	  boolean isValid = true;
      if (password.length() > 15 || password.length() < 8)
      {
              System.out.println("Password must be less than 20 and more than 8 characters in length.");
              isValid = false;
      }
      String upperCaseChars = "(.*[A-Z].*)";
      if (!password.matches(upperCaseChars ))
      {
              System.out.println("Password must have atleast one uppercase character");
              isValid = false;
      }
      String lowerCaseChars = "(.*[a-z].*)";
      if (!password.matches(lowerCaseChars ))
      {
              System.out.println("Password must have atleast one lowercase character");
              isValid = false;
      }
      String numbers = "(.*[0-9].*)";
      if (!password.matches(numbers ))
      {
              System.out.println("Password must have atleast one number");
              isValid = false;
      }
      String specialChars = "(.*[@,#,$,%,_].*$)";
      if (!password.matches(specialChars ))
      {
              System.out.println("Password must have atleast one special character among @#$%_");
              isValid = false;
      }
      return isValid; 
}



  
}
   
 

