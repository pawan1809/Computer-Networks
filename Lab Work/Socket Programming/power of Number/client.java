/*
Code For: Power of Number
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Intagram: https://www.instagram.com/rs_pawankumar/
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
*/

import java.io.*;
import java.net.*;

class client {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 1001);

        // to send data to the server
        PrintStream toServer = new PrintStream(s.getOutputStream());

        // to read data coming from the server
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // to read data from the keyboard
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String serverInput;
        System.out.println();

        String a,b;

        a=input.readLine();
        b=input.readLine();
        


        toServer.println(a);
        toServer.println(b);
        
        // receive from the server
        serverInput = fromServer.readLine();

        System.out.println(serverInput);

        // close connection.
        toServer.close();
        fromServer.close();
        input.close();
        s.close();
    }
}