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
        String tmp="";
        for(int i=1;i<=n;i++)
            tmp+="*";
        sendData = tmp.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
        int end=n-1;
        while(end>1)
        {
            String str="*";
            for(int k=2;k<end;k++)
                str+=" ";
            str+="*";
            sendData = str.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            end--;
        }
        tmp="*";
        sendData = tmp.getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
        serverSocket.close();
        System.exit(0);
    }
}