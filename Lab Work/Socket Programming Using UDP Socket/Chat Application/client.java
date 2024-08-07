//chat
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
class client
{
    public static DatagramSocket clientsocket;
    public static DatagramPacket dp;
    public static BufferedReader dis;
    public static InetAddress ia;
    public static byte buf[] = new byte[1024];
    public static int cport = 789, sport = 790;
    public static void main(String[] a) throws IOException
    {
        clientsocket = new DatagramSocket(cport);
        dp = new DatagramPacket(buf, buf.length);
        dis = new BufferedReader(new InputStreamReader(System.in));
        ia = InetAddress.getLocalHost();
        System.out.println("Client is Running... Type 'STOP'to Quit");
        while(true)
        {
            String str = new String(dis.readLine());
            buf = str.getBytes();
            if(str.equals("STOP"))
            {
                System.out.println("Terminated...");
                clientsocket.send(new
                DatagramPacket(buf,str.length(), ia,
                sport));
                break;
            }
            clientsocket.send(new DatagramPacket(buf,
            str.length(), ia, sport));
            clientsocket.receive(dp);
            String str2 = new String(dp.getData(), 0,
            dp.getLength());
            System.out.println("Server: " + str2);
        }
    }
}