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
class server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(1001);
        System.out.println("Waiting for connection...");
        Socket s = ss.accept();
        System.out.println("Connection established");
        PrintStream toClient = new PrintStream(s.getOutputStream());
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String rows;
        int n;
        rows=fromClient.readLine();
        n=Integer.parseInt(rows);
        String tmp="";
        for(int i=1;i<=n;i++)
            tmp+="*";
        toClient.println(tmp);
        int end=n-1;
        while(end>1)
        {
            String str="*";
            for(int k=2;k<end;k++)
                str+=" ";
            str+="*";
            toClient.println(str);
            end--;
        }
        tmp="*";
        toClient.println(tmp);
        toClient.close();
        fromClient.close();
        input.close();
        ss.close();
        s.close();
        System.exit(0);
    }
}