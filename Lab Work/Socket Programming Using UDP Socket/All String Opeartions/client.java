// All String Operations 
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/


import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5000;
    private static final int BUFFER_SIZE = 1024;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
            System.out.print("Enter operation: ");
            String operation = scanner.nextLine();
            System.out.print("Enter input string: ");
            String inputString = scanner.nextLine();
            System.out.print("Enter destination string: ");
            String destinationString = scanner.nextLine();
            System.out.print("Enter second string: ");
            String secondString = scanner.nextLine();
            String request = operation + "," + inputString + "," + destinationString + "," + secondString;
            byte[] requestBuffer = request.getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestBuffer, requestBuffer.length, serverAddress,SERVER_PORT);
            socket.send(requestPacket);
            byte[] buffer = new byte[BUFFER_SIZE];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);
            scanner.close();
            socket.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}