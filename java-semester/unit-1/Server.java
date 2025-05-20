import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Waiting for client...");
            
            while (true) {
                try {
                    Socket client = server.accept();
                    System.out.println("Client connected.");
                    
                    BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter output = new PrintWriter(client.getOutputStream(), true); 

                    output.println("Connected to server. Type 'exit' to close connection.");

                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Client: " + msg);
                        if (msg.equalsIgnoreCase("exit")) break;
                    }

                    
                    input.close();
                    output.close();
                    client.close();
                    
                    System.out.println("Client connection terminated.");
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}
