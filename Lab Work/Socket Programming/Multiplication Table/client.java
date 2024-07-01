/*
Code For: Multiplication Table
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Intagram: https://www.instagram.com/rs_pawankumar/
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
*/



import java.io.*;
import java.net.*;

class client
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("Enter the number:");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String sentence = inFromUser.readLine();

        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, 7009);

        clientSocket.send(sendPacket);

        DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(receivePacket);

        String modifiedSentence =new String(receivePacket.getData());

        System.out.println("FROM SERVER:" + modifiedSentence);

        clientSocket.close();
    }
}