// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class changePassword extends HttpServlet {
	
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
      
      // Set response content type
      response.setContentType("text/html");
      
      loginInfo obj=new loginInfo();
	  String id=obj.getId();

      PrintWriter out = response.getWriter();
      String title = "Change Password";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<form action=\"changePassProcess\" method=\"post\">" +
            "<p>ID: <input type=\"text\" name=\"id\" value='" + id +"' readonly /></p>" +
            "<p>New Password: <input type=\"password\" name=\"newPass\" /></p>" +
            "<p>Confirm Password: <input type=\"password\" name=\"confirmPass\" /></p>" +
            "<p><button type=\"submit\">Submit</button></p>" +
            "</form>" +
            "</body>" +           
         "</html>"
      );
      
     
   }
   
}




