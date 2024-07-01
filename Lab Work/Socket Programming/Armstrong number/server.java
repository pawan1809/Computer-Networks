/*
Code For: armstrong Number
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Contact : +91-8960421341		
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
*/


import java.net.*;
class server {

    public static int solve(int number)
    {
        int originalNumber, remainder, result = 0, n = 0;

        originalNumber = number;

        for (;originalNumber != 0; originalNumber /= 10, ++n);
        
        originalNumber = number;

        for (;originalNumber != 0; originalNumber /= 10)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
        }

        
        if(result == number)
            return 1;
        else
           return 0;

    }

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());

            InetAddress IPAddress = receivePacket.getAddress();

            int port = receivePacket.getPort();

            int num = Integer.parseInt(sentence);

            int val = solve(num);

            String ans="";

            if(val==0)
            ans="This is not an armstrong number";
            else
            ans="This is an armstrong number";

            sendData = ans.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            System.out.println("Sending response to client!!!");
            serverSocket.send(sendPacket);

            serverSocket.close();
    }
}