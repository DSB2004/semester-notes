// Session tracking in web applications is an important concept for maintaining user 
// state across different requests. In Java servlets, you can achieve session tracking
// using either cookies or session objects. 

// Here's an overview of both methods:


// Session Tracking Using Cookies
    // Cookies are small pieces of data stored by the client (browser) and sent with every 
    // request to the server. You can use cookies to track users between requests.

import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("set".equals(action)) {
            // Set the cookie
            Cookie userCookie = new Cookie("user", "id=1&email=johndoe@ex.com&name=John Doe");
            userCookie.setMaxAge(60 * 60);  // 1 hour
            userCookie.setPath("/");
            userCookie.setSecure(true);  // Only send over HTTPS
            userCookie.setHttpOnly(true);  // Can't be accessed via JavaScript
            userCookie.setSameSite("Strict");  // Only send cookies in first-party contexts
            res.addCookie(userCookie);
            res.getWriter().println("Cookie has been set!");
        } else if ("get".equals(action)) {
            // Get the cookie
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("user".equals(cookie.getName())) {
                        res.getWriter().println("Cookie value: " + cookie.getValue());
                    }
                }
            }
        } else {
            res.getWriter().println("Invalid action.");
        }
    }

}





// Feature	            Cookies	                                        Sessions

// Storage Location	    Stored on the client's browser (client-side)	Stored on the server (server-side)
// Size Limit	        Limited to around 4 KB	                        Limited only by server memory
// Expiration	        Can be set to expire after a certain time	    Session expires when the session times out or the user logs out
// Security	            Less secure as it is stored on the client's     More secure as the data is stored server-side and not 
//                       side and can be manipulated by the client	     exposed to the client
// Use Cases	        Used for simple user preferences, remembering 	Used for storing complex session data like shopping carts, user states, etc. 
//                       login credentials