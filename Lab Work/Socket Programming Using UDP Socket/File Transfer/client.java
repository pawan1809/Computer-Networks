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

public class client {
	public static void main(String args[]) throws Exception {
		byte b[] = new byte[1024];
		FileInputStream f = new FileInputStream("/home/prateek/Documents/Labs/ACNLab/SocketCodes/Assign_06/3/test.txt");
		DatagramSocket dsoc = new DatagramSocket(2000);
		int i = 0;
		while (f.available() != 0) {
			b[i] = (byte) f.read();
			i++;
		}
		f.close();
		dsoc.send(new DatagramPacket(b, i, InetAddress.getLocalHost(), 1000));
		dsoc.close();
	}

}