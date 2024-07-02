// string Comparision
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
class client {
    public static void main(String args[]) throws Exception {
        System.out.println("Enter both strings-> ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromUser2 = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData1 = new byte[1024];
        byte[] sendData2 = new byte[1024];
        byte[] receiveData = new byte[1024];
        String s1 = inFromUser.readLine();
        String s2 = inFromUser2.readLine();
        sendData1 = s1.getBytes();
        sendData2 = s2.getBytes();
        DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, 7009);
        DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, 7009);
        clientSocket.send(sendPacket1);
        clientSocket.send(sendPacket2);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}