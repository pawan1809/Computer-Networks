// date and time
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/


import java.net.*;
import java.time.*;
class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            System.out.println("packet recieved!!!");
            String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            LocalDate today =LocalDate.now();
            LocalTime time = LocalTime.now(); 
            String ans=String.valueOf("Date "+today +" Time "+time);
            sendData = ans.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            System.out.println("Sending response to client!!!");
            serverSocket.send(sendPacket);
            serverSocket.close();
    }
}