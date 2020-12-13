import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class forgotPassword extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      PrintWriter out = response.getWriter();
		      String title = "Add Student";
		      String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		         
		      out.println(docType +
		         "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		            "<form action=\"addStudentProcess\" method=\"post\">" +
		            "<p>Name: <input type=\"text\" name=\"newName\" /></p>" +
		            "<p>Password: <input type=\"text\" name=\"newPass\" /></p>" +
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
