// Write a program to perform chatting operations using TCP socket Programming.

import java.io.*;
import java.net.*;

class server {

    public static void main(String args[]) throws Exception {

        // Create server Socket
        ServerSocket ss = new ServerSocket(1001);

        System.out.println("Waiting for connection...");

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream toClient = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // to read data from the keyboard
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // server executes continuously
        while (true) {

            String str, str1;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while ((str = fromClient.readLine()) != null) {
                System.out.println("Client says : " + str);
                str1 = input.readLine();

                // send to client
                toClient.println(str1);
            }

            // close connection
            toClient.close();
            fromClient.close();
            input.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}