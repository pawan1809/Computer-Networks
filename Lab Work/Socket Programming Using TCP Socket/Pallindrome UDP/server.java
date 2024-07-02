// Write a program to check Whether a Number is Palindrome or Not using TCP socket Programming.
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

class server {
    static boolean palindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

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
                str1 = str;

                str1 += " is ";
                if (palindrome(str) == true) {
                    System.out.println(" - is palindrome");
                    str1 += "palindrome";
                }
                else {
                    System.out.println(" - is not a palindrome");
                    str1 += "not Palindrome";
                }
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