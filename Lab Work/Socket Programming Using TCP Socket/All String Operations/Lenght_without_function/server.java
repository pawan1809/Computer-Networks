//
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

public static String reverseString(String str) { 

 String ans = ""; 

 for (int i = str.length()-1; i>=0; i--) { 

ans += str.charAt(i); 

 } 

 return ans; 

} 

 

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

 while (true) { 

 str = fromClient.readLine(); 

 if (str.equals("exit")) 

 break; 

 System.out.print("Received string : "); 

 System.out.println(str); 

 String revstr = reverseString(str); 

 toClient.print(revstr + "\n"); 

 System.out.println(revstr); 

 System.out.println("Reversed string sent..."); 

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