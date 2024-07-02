// All string Operations

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

public class server {
    private static final int PORT = 5000;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {

        try {

            DatagramSocket socket = new DatagramSocket(PORT);

            System.out.println("Server running on port " + PORT);

            byte[] buffer = new byte[BUFFER_SIZE];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String receivedString = new String(packet.getData(), 0, packet.getLength());

                System.out.println("Received string from client: " + receivedString);

                String[] stringArgs = receivedString.split(",");

                String operation = stringArgs[0];

                String inputString = stringArgs[1];

                String response = "";

                switch (operation) {

                    case "1":

                        response = inputString.toUpperCase();

                        break;
                    case "2":

                        response = Integer.toString(inputString.length());

                        break;
                    case "3":

                        String destinationString = stringArgs[2];

                        System.arraycopy(inputString.toCharArray(), 0, destinationString.toCharArray(), 0,
                                inputString.length());

                        response = destinationString;

                        break;
                    case "4":

                        String secondString = stringArgs[2];
                        response = inputString.concat(secondString);

                        break;
                    case "5":

                        String secondString1 = stringArgs[2];
                        response = inputString.compareTo(secondString1) == 0 ? "0" : "-1";

                        break;
                    case "6":

                        response = new StringBuilder(inputString).reverse().toString();

                        break;

                    case "7":

                        response = inputString.toLowerCase();

                        break;
                    case "8":

                        response = inputString.toUpperCase();

                        break;
                    default:

                        response = "Invalid operation!";

                        break;

                }

                byte[] responseBuffer = response.getBytes();

                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length,
                        packet.getAddress(), packet.getPort());
                socket.send(responsePacket);

                socket.close();

            }
            

        } catch (IOException e) {

            System.err.println("Error: " + e.getMessage());

        }

    }

}