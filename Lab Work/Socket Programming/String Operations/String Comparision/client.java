/*
Code For: strings comparison
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

String userInput; 

System.out.println(); 

System.out.println("Say something \n"); 

while (!(userInput = input.readLine()).equals("exit")) { 

toServer.print(userInput + "\n"); 

 } 

 toServer.close(); 

 fromServer.close(); 

input.close(); 

 s.close(); 

} 

} 