// Sum of Digit
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/


import java.net.*;
class server
{

    public static String fn(String n){

        System.out.println(n.length());

        int a=Integer.parseInt(n);

        int ans=0;
        while(a>0){
            ans+=a%10;
            a/=10;
        }

        n=Integer.toString(ans);
        return n;
    }
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(7009);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];


        DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);

        serverSocket.receive(receivePacket);

        String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());

        InetAddress IPAddress = receivePacket.getAddress();

        int port = receivePacket.getPort();

        String capitalizedSentence = fn(sentence);

        sendData = capitalizedSentence.getBytes();

        DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress,port);

        System.out.println("Sending Sum to Client");
        serverSocket.send(sendPacket);

        serverSocket.close();
    }

}