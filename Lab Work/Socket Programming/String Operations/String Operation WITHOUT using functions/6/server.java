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
        int n,x;
        rows=fromClient.readLine();
        x=Integer.parseInt(rows);
        n=(2*x)-1;
        for(int i=1;i<n;i+=2)
        {
            String str1="",str2="";
            int gap=(n-i)/2;
            for(int j=1;j<=gap;j++)
                str1+=" ";
            for(int j=1;j<=i;j++)
            {
                if(j==1 || j==i)
                    str2+="*";
                else
                    str2+=" ";
            }
            String str3=str1+str2+str1;
            toClient.println(str3);
        }
        String tmp="";
        for(int i=1;i<=n;i++)
        {
            if(i%2==1)
                tmp+="*";
            else
                tmp+=" ";
        }
        toClient.println(tmp);
        toClient.close();
        fromClient.close();
        input.close();
        ss.close();
        s.close();
        System.exit(0);
    }
}