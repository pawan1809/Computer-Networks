// Palindrome
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/



import java.net.*;
class server {

    public static int solve(String str)
    {
        String s = str;
        int r=s.length()-1;
        int l=0;

        boolean chk = true;

        while(l<r)
        {
            if(s.charAt(r)!=s.charAt(l))
            {
                chk=false;
                System.out.println("index-> "+l+"  "+r);
                break;
            }
            r--;
            l++;
        }

        if(chk==true)
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

            int val = solve(sentence.toString());
            

            String ans="";

            if(val==0)
            ans="This is not a palindrome";
            else
            ans="This is a palindrome";

            sendData = ans.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            System.out.println("Sending response to client!!!");
            serverSocket.send(sendPacket);

            serverSocket.close();
    }
}