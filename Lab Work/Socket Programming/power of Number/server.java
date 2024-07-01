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

class server {
    
    public static int myPow(int x, int n) {
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        if(n<0)
            return 1/x*myPow(1/x ,-(n + 1));
        if(n%2==1)
            return x*myPow(x*x,n/2);
        return myPow(x*x,n/2);
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

        String a,b,c;
        int x,y,z;
        

        a=fromClient.readLine();
        b=fromClient.readLine();

        x=Integer.parseInt(a);
        y=Integer.parseInt(b);

        z=myPow(x,y);

        c=String.valueOf(z);

        toClient.println(c);
        

        // close connection
        toClient.close();
        fromClient.close();
        input.close();
        ss.close();
        s.close();

        // terminate application
        System.exit(0);

        
    }
}