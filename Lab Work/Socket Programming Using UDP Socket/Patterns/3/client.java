import java.io.*;
import java.net.*;
class client {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        String rows = inFromUser.readLine();
        int n=Integer.parseInt(rows);
        sendData = rows.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7009);
        clientSocket.send(sendPacket);
        for(int i=0;i<n;i++){
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println(modifiedSentence);
        }
        clientSocket.close();
    }
}