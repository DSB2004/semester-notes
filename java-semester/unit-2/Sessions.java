// Session Tracking Using HttpSession
    // Sessions allow you to store data on the server side for a specific user. The server generates 
    // a unique session ID that is sent to the client as a cookie, and on subsequent requests, the 
    // client sends the session ID back to the server.


import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/createSession")
public class Sessions extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get the session object (creates a new session if it doesn't exist)
        HttpSession session = req.getSession(true);
        String username=req.getParameter("username");
        // Store user information in the session
        session.setAttribute("username", username);
        
        res.getWriter().println("Session created and username stored.");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Retrieve the session object
        HttpSession session = req.getSession(false); // false to not create a new one if it doesn't exist

        if (session != null) {
            // Retrieve stored attributes from the session
            String username = (String) session.getAttribute("username");
            res.getWriter().println("Hello, " + username);
        } else {
            res.getWriter().println("No session found.");
        }
    }
    
}

