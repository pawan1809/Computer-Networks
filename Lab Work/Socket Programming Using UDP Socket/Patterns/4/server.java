import java.net.*;
class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        int n,x;
        serverSocket.receive(receivePacket);
        String rows = new String(receivePacket.getData(),0,receivePacket.getLength());
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        x=Integer.parseInt(rows);
        n=(2*x)-1;
        for(int i=1;i<=n;i+=2)
        {
            String str1="",str2="";
            int gap=(n-i)/2;
            for(int j=1;j<=gap;j++)
                str1+=" ";
            for(int j=1;j<=i;j++)
            {
                if(j%2==1)
                    str2+="*";
                else
                    str2+=" ";
            }
            String str3=str1+str2+str1;
            sendData = str3.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
        serverSocket.close();
        System.exit(0);
    }
}