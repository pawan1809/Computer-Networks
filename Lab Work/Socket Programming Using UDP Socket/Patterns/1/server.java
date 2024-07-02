import java.net.*;
class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        int n;
        serverSocket.receive(receivePacket);
        String rows = new String(receivePacket.getData(),0,receivePacket.getLength());
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        n=Integer.parseInt(rows);
        for(int i=0;i<n;i++)
        {
            String str="";
            for(int j=0;j<=i;j++)
                str+="*";
            sendData = str.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
        serverSocket.close();
        System.exit(0);
    }
}