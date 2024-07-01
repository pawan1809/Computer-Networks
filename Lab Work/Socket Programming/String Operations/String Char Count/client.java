/*
Code For: strings characters count
Author	: Pawan Kumar
Email	: pawankumar.iiitdmj@gmail.com
Intagram: https://www.instagram.com/rs_pawankumar/
Youtube : https://www.youtube.com/@dr_pawan
Github  : https://github.com/pawan1809
*/

import java.io.*; 
import java.net.*; 
class client { 
 public static void main(String args[]) throws Exception { 
  Socket s = new Socket("localhost", 1001); 
  PrintStream toServer = new PrintStream(s.getOutputStream()); 
  BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream())); 
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
  System.out.println(); 
  System.out.println("Say something \n"); 
  while (true) { 
   System.out.print("Str : "); 
   String str = input.readLine(); 
   toServer.print(str + "\n"); 
   if (str.equals("exit")) 
   break; 
   String loweString = fromServer.readLine(); 
   System.out.println("Uppercase characters : " + loweString); 
  } 
  toServer.close(); 
  fromServer.close(); 
  input.close(); 
  s.close(); 
 } 
} 