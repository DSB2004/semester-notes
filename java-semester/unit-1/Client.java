
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import  java.net.*;
public class Client{
    public static void main(String[] args) {
    try {
        // while(true){}
        Socket client=new Socket("localhost",5000);
        PrintWriter output=new PrintWriter(client.getOutputStream(),true);
        output.println("Hello from client");
        output.flush();
        BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));
        String msg;
            while ((msg = input.readLine()) != null) {
                System.out.println("Server: " + msg);
            }
        client.close();


    
    } catch (Exception e) {

    }
}}