// File Transfer
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/
import java.io.*;
import java.net.Socket;
public class client {
	private static DataOutputStream dataOutputStream = null;
	private static DataInputStream dataInputStream = null;
	public static void main(String[] args)
	{
		try (Socket socket = new Socket("localhost", 900)) {
		dataInputStream = new DataInputStream(
				socket.getInputStream());
			dataOutputStream = new DataOutputStream(
				socket.getOutputStream());
			System.out.println(
				"Sending the File to the Server");
		sendFile(
				"/home/prateek/Documents/Labs/ACNLab/Socket Codes/Assign_04/3/test.txt");

			dataInputStream.close();
			dataInputStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void sendFile(String path)
		throws Exception
	{
		int bytes = 0;
		File file = new File(path);
		FileInputStream fileInputStream
			= new FileInputStream(file);
		dataOutputStream.writeLong(file.length());
		byte[] buffer = new byte[4 * 1024];
		while ((bytes = fileInputStream.read(buffer))
			!= -1) {
		dataOutputStream.write(buffer, 0, bytes);
			dataOutputStream.flush();
		}
		fileInputStream.close();
	}
}