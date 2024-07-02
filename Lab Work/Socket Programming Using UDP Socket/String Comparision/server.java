// string Comparision
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/



import java.net.*;
class server {
    public static String solve(String a,String b)
    {
        int val = a.compareTo(b);
        if(val==0)
        return "strings are equal";
        else if(val>0)
        return "1st String is lexographically bigger than 2nd String";
        else
        return "2nd String is lexographically bigger than 1st String";
    }
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData1 = new byte[1024];
        byte[] receiveData2 = new byte[1024];
        byte[] sendData = new byte[1024];
            DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
            DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
            serverSocket.receive(receivePacket1);
            serverSocket.receive(receivePacket2);
            String a = new String(receivePacket1.getData(),0,receivePacket1.getLength());
            String b = new String(receivePacket2.getData(),0,receivePacket2.getLength());
            InetAddress IPAddress = receivePacket1.getAddress();
            int port = receivePacket1.getPort();
            String ans=solve(a,b);
            sendData = ans.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            System.out.println("Sending response to client!!!");
            serverSocket.send(sendPacket);
            serverSocket.close();
    }
}