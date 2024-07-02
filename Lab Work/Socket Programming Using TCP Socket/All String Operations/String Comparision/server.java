// String Comparision
/*
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
LinkedIn: https://www.linkedin.com/in/pawaniiitdmj/
Intagram: https://www.instagram.com/rs_pawankumar/
*/


import java.io.*; 

import java.net.*; 

class server { 

 public static void main(String args[]) throws Exception { 

ServerSocket ss = new ServerSocket(1001); 

System.out.println("Waiting for connection..."); 

Socket s = ss.accept(); 

System.out.println("Connection established"); 

PrintStream toClient = new PrintStream(s.getOutputStream()); 

BufferedReader fromClient = new BufferedReader(new InputStreamReader(s.getInputStream())); 

BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 

while (true) { 

String str; 

while ((str = fromClient.readLine()) != null) { 

if (str.equals("exit")) 

break; 

System.out.print("Received string : "); 

System.out.println(str); 

 

System.out.println(str.toUpperCase()); 

} 

toClient.close(); 

fromClient.close(); 

input.close(); 

ss.close(); 

s.close(); 

System.exit(0); 

 

} 

} 

} 