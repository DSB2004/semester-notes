
// // Servlet Overview and Architecture

    // Java Servlet is a server-side component that handles HTTP requests and responses.

    // Follows a request-response model.

    // Resides inside a Servlet container (like Tomcat).

    // Used for web applications, login systems, form processing, etc.





// // Servlet Architecture:

    // Client sends HTTP request

    // Web server forwards to servlet

    // Servlet processes and sends back a response

    // Response returned to client




// // Interface Servlet and the Servlet Lifecycle
   
   // Interface

    // javax.servlet.Servlet is the core interface with methods:

    // init(): initialization

    // service(): handles requests

    // destroy(): cleanup

    // getServletConfig()

    // getServletInfo()

   // Lifecycle:

        // Loading and instantiation

        // Initialization (init())

        // Request handling (service())

        // Destruction (destroy())


import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.io.*;


@WebServlet("/api/test") 
public class Servlet extends  HttpServlet {
    
    @Override
     protected  void doPost(HttpServletRequest req,HttpServletResponse res){

        res.setContentType("text/plain");
        StringBuilder body=new StringBuilder();

        BufferedReader reader=req.getReader();

        String line;
        try {
            while((line=reader.readLine())!=null){
                body.append(line).append('\n');
            }
        } catch (Exception e) {
        }


        PrintWriter out=res.getWriter();
        out.println("Received");
        out.println(body.toString());
        
     }
}