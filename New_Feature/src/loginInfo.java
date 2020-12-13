// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*; 

// Extend HttpServlet class
public class loginInfo extends HttpServlet {
 
	private boolean login=false;
	private Statement statement=null;
	private Connection connection = null;
	static String id= null;
	
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
	   id=request.getParameter("userID");
	   String pw=request.getParameter("pw");
	  
      
      // Set response content type
      response.setContentType("text/html");
      
      try{
    	  Class.forName("com.mysql.jdbc.Driver");

    	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useTimezone=true&serverTimezone=UTC", "root", "12345");	
    	  	
    	  		// Create a statement to retrieve objects
    	  		statement = connection.createStatement();        

    	  		String sql = "select name from Student where idstudent='"+ id +"' and password='"+ pw +"'";
    	  		
    	  		
    	  		// Retrieve results from the table
    	  		ResultSet rs = statement.executeQuery(sql); 
    	  		
    	  		if(rs.next()) {
    	  	    	login = true;
    	  	    	
    	  	    	
    	  	    } 
    	  		}
    	  catch(Exception e) {
    	  	   e.getMessage();
    	  	}

      if(login) {

    	  PrintWriter out = response.getWriter();
          String title = "Student Info";
          String docType =
             "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
          
         
          out.println(docType +
             "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                   "<h1 align = \"center\">" + "STUDENT INFORMATION" + "</h1>\n" +
                   "<ul>\n" +
                      " <b>Succefully login!</b> \n <br/>" +
                      "  <li><b>Login ID</b>: "
                      + request.getParameter("userID") + "\n" +
                   "</ul>\n" +
                   "<form action=\"changePassword\">" +
    	             "<input type=\"submit\" value=\"Change Password\">" +
    	             "</form>" +
                "</body>" +
             "</html>"
          );
          
          try {
  		    statement = connection.createStatement();
  		    ResultSet rs = statement.executeQuery("select idstudent, name, department, english, math, science, malay from Student");
            
  	
  		 
              
  		    
  		    
  		    out.println(docType +
  		    		"<table border=\"1\">\n" +
  		    		  "<tr>" +
  		  	  	        "<th>ID</th>" + 
  		  	  	        "<th>Name</th>" +
  		  	  	        "<th>Department</th>" +
  		  	  	        "<th>English</th>" +
  		  	  	        "<th>Math</th>" +
  		  	        	"<th>Science</th>" +
  		  	  	        "<th>Malay</th>" +
  		  	  	        "<th>Average Marks</th>" +
  		  	  	      "</tr>" 	);
          
  		  while(rs.next()) { 
  			 double english=rs.getDouble("english");
             double math=rs.getDouble("math");
             double science=rs.getDouble("science");
             double malay=rs.getDouble("malay");
             double total=(english+math+science+malay)/4;
             
             out.println(docType +
            		 "<tr>" + 
              	    "<td>" + rs.getString("idstudent") +"</td>" +
              	    "<td>" + rs.getString("name") + "</td>" + 
              	    "<td>" + rs.getString("department") + "</td>" + 
              	    "<td>" + english + "</td>" +
              	    "<td>" + math + "</td>" +
              	    "<td>" + science +"</td>" + 
              	    "<td>" + malay +"</td>" + 
              	    "<td>" + total + "</td>" +
              	    "<tr>" 
            		 );
          }
  		  
  		 out.println(docType +
  				"</table>" +
  	             "<form action=\"addStudent\">" +
  	             "<input type=\"submit\" value=\"Add New Student\">" +
  	             "</form>" 
        		 );
    	  
      }
          catch(Exception e) {
  	    	out.println(e.getMessage());
  	    }
      
   }
      else {
    	  
    	  System.out.println("login failed!!");
    	  
      }
} 
   
   public static String getId(){
	    return id;
  }
  
}
