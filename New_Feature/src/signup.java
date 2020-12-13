// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class signup extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Sign Up";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<form action=\"signupProcess\" method=\"post\">" +
            "<p>Name: <input type=\"text\" name=\"newName\" /></p>" +
            "<p>Password: <input type=\"password\" name=\"newPass\" /></p>" +
            "<p>Password: <input type=\"password\" name=\"confirmPass\" /></p>" +
            "<p>Department: <input type=\"text\" name=\"newDep\" /></p>" +
            "<p>English: <input type=\"text\" name=\"eng\" /></p>" +
            "<p>Math: <input type=\"text\" name=\"math\" /></p>" +
            "<p>Science: <input type=\"text\" name=\"science\" /></p>" +
            "<p>Malay: <input type=\"text\" name=\"malay\" /></p>" +
            "<p><button type=\"submit\">Submit</button></p>" +
            "</form>" +
            "</body>" +           
         "</html>"
      );
   }
}

