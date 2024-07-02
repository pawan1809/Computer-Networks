// Power of a nUMBER
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
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String a = new String(receivePacket.getData(),0,receivePacket.getLength());
        serverSocket.receive(receivePacket);
        String b = new String(receivePacket.getData(),0,receivePacket.getLength());
        int x,y,z;
        x=Integer.parseInt(a);
        y=Integer.parseInt(b);
        z=myPow(x,y);
        String c=String.valueOf(z);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        sendData = c.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        System.out.println("Sending response to client!!!");
        serverSocket.send(sendPacket);
        serverSocket.close();
        System.exit(0);
    }
}