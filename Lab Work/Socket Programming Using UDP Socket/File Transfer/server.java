// File Transfer
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
	public static void main(String args[]) throws IOException {
		byte b[] = new byte[3072];
		DatagramSocket dsoc = new DatagramSocket(1000);
		FileOutputStream f = new FileOutputStream("/home/prateek/Documents/Labs/ACNLab/SocketCodes/Assign_06/3/test_new.txt");
		DatagramPacket dp = new DatagramPacket(b, b.length);
		dsoc.receive(dp);
		String tmp = new String(dp.getData(), 0, dp.getLength());
		b = tmp.getBytes();
		f.write(b);
	}
}