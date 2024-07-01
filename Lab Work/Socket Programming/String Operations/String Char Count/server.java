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

class server { 

 public static void main(String args[]) throws Exception { 

  ServerSocket ss = new ServerSocket(1001); 

  System.out.println("\nWaiting for connection..."); 

  Socket s = ss.accept(); 

  System.out.println("Connection established\n"); 

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

    int[] count = new int[26]; 

    for (int i = 0; i < 26; i++) 

     count[i] = 0; 

    for (int i = 0; i < str.length(); i++) { 

     if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') { 

      count[str.charAt(i) - 'A']++; 

     } 

    } 

    String ans = ""; 

    for (int i = 0; i < 26; i++) { 

     if (count[i] > 0) { 

      ans += (char)(i + 'A') + " "; 

     } 

    } 

    toClient.print(ans + "\n"); 

    System.out.println("Sent..."); 

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