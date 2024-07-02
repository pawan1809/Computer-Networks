// Write a program to perform chatting operations using TCP socket Programming.
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/


import java.io.*;
import java.net.*;

class client {

    public static void main(String args[]) throws Exception {

        // Create client socket
        Socket s = new Socket("localhost", 1001);

        // to send data to the server
        PrintStream toServer = new PrintStream(s.getOutputStream());

        // to read data coming from the server
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // to read data from the keyboard
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String userInput, serverInput;
        System.out.println();
        System.out.println("Say something \n");

        // repeat as long as exit
        // is not typed at client
        while (!(userInput = input.readLine()).equals("exit")) {

            // send to the server
            toServer.print(userInput + "\n");

            // receive from the server
            serverInput = fromServer.readLine();

            System.out.println("Server says : " + serverInput);
        }

        // close connection.
        toServer.close();
        fromServer.close();
        input.close();
        s.close();
    }
}