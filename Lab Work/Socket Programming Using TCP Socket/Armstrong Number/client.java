// armstrong Number
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
        Socket s = new Socket("localhost", 1001);
        PrintStream toServer = new PrintStream(s.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String userInput, serverInput;
        System.out.println();
        System.out.println("Say something \n");
        while (!(userInput = input.readLine()).equals("exit")) {
            toServer.print(userInput + "\n");
            serverInput = fromServer.readLine();
            System.out.println("Server says : " + serverInput);
        }
        toServer.close();
        fromServer.close();
        input.close();
        s.close();
    }
}