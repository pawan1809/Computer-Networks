/*
Code For: String Operations with using predefined functions
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
        PrintStream toServer = new PrintStream(s.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String serverInput;
        System.out.println();
        String rows;
        int n;
        rows=input.readLine();
        n=Integer.parseInt(rows);
        toServer.println(rows);
        for(int i=0;i<n;i++){
            serverInput = fromServer.readLine();
            System.out.println(serverInput);
        }
        toServer.close();
        fromServer.close();
        input.close();
        s.close();
    }
}