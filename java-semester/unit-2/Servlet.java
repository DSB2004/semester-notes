
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

    //  init()
        // Called only once when the servlet is first loaded into memory.

        // Used to initialize resources, such as opening database connections, reading config files, etc.

        // Receives a ServletConfig object, which holds initialization parameters.

        // You can override it to set up things before any request is handled.

    // 2. doGet() / doPost()
        // Part of the request-handling phase.

        // doGet() handles HTTP GET requests.

        // doPost() handles HTTP POST requests.

        // These methods are called every time a client makes a request to the servlet.

        // You typically override these to generate a response (HTML, JSON, plain text, etc.).

    // 3. destroy()
        // Called once when the servlet is being taken out of service (e.g., server shutdown or redeployment).

        // Used to clean up resources like closing DB connections, releasing memory, stopping threads, etc.

    // 4. getServletConfig()

        // Returns the ServletConfig object for the servlet.

        // Useful for accessing initialization parameters defined in the deployment descriptor (web.xml) or annotations.

    // 5. getServletInfo()

        // Returns a string description of the servlet.

        // Usually contains information like version, author name, purpose, etc.

        // Mostly used for logging and debugging.


   // Lifecycle:

        // Loading and instantiation

        // Initialization (init())

        // Request handling (service())

        // Destruction (destroy())

//  What is web.xml?

//  web.xml is the deployment descriptor file for a Java web application. It’s part of the Java Servlet specification
//  and is located in the WEB-INF directory of your project.


// Annotation vs web.xml
// web.xml: XML-based configuration (older style).

// Annotations (@WebServlet): Modern way (Java EE 6+), easier and cleaner.

// Both can coexist, but annotations are preferred for small/medium apps, while web.xml is useful for complex or legacy applications.






// a simple CURD endpoint for USER table to manage info of a user like name .email,phone number etc


import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.Gson; 
import java.sql.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;
// entity
class User {

    private String name;
    private String email;
    private String phone_number;

    public User (){}

    public void createUser(String name, String email, String phone_number) throws IllegalArgumentException{
        if(!validateUser(name, email, phone_number)){
         throw new IllegalArgumentException("Validation failed for User");
        }
        this.name=name;
        this.email=email;
        this.phone_number=phone_number;
    }   

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone_number;
    }
    boolean validateUser(String name, String email, String phone_number) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (phone_number == null || !isValidPhoneNumber(phone_number)) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
        return true;
    }
    private boolean isValidEmail(String email) {
            return email.contains("@") && email.contains(".");
    }
    private boolean isValidPhoneNumber(String phone_number) {
        return phone_number.matches("[0-9]+") && phone_number.length() == 10;
    }
}


@WebServlet("/api/user") 
public class Servlet extends HttpServlet {
    private Connection conn;

    @Override
    public void init() {
        try {
            String url = "jdbc:mysql://localhost:3306/my_db"; // Example URL
            String user = "yourUsername";
            String password = "yourPassword";
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Error connecting to Database: " + e.getMessage());
        }
        finally{
            System.out.println("Servlet initialized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out=new PrintWriter(res.getWriter());

        res.setContentType("text/plain");
        StringBuilder body = new StringBuilder();

        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String phone_number=req.getParameter("phone_number");

        User user=new User();

        try {
            user.createUser(name, email, phone_number);
            PreparedStatement st=conn.prepareStatement("INSERT INTO USER (NAME,EMAIL,PHONE_NUMBER) VALUES (?,?,?);");
            st.setString(1,user.getName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPhone());
            st.executeUpdate();
            res.setStatus(HttpServletResponse.SC_CREATED);
            out.println("User created successfully");   

        } catch (IllegalArgumentException e) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("User validation failed");
        }catch(SQLException sql_e){
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Database fucked up");
        }

        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("application/json"); 
        PrintWriter out=new PrintWriter(res.getWriter());
        String search = req.getParameter("name");
        PreparedStatement st=null;
        ResultSet rs=null;
        List<User> list =new ArrayList<>();
        try {
            if(search==null){
               st=conn.prepareStatement("SELECT * FROM USER");
            }else{
                st=conn.prepareStatement("SELECT * FROM USER WHERE NAME LIKE ?");
                st.setString(1, "%" + search + "%"); 
            }
            rs = st.executeQuery();

            while(rs.next()){
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE_NUMBER");
                User result=new User();
                result.createUser(name, email, phone);
                list.add(result);
            }
            Gson gson=new Gson();
            String jsonResponse = gson.toJson(list);
            res.setStatus(HttpServletResponse.SC_OK);
            out.print(jsonResponse);
        } catch(SQLException sql_e){
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Database fucked up");
        }
        
    }

    @Override 
    public void destroy() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
        finally{
            System.out.println("Servlet destroyed");
        }
    }
}
