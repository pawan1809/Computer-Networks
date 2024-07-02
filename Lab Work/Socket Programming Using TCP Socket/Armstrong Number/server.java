// armstrong Number
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
    static boolean check(int n) {
        int sum = n;
        int digitSum = 0;
        while (n > 0) {
            int digit = n % 10;
            digitSum += digit * digit * digit;
            n /= 10;
        }
        return sum == digitSum;
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
            while ((str = fromClient.readLine()) != null) {
                Boolean validnum = true;
                System.out.println("Client number : " + str);
                int num = 0;
                String str1 = "";
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                        validnum = false;
                        break;
                    }
                    num = num * 10 + str.charAt(i) - '0';
                }
                if (check(num)) {
                    str1 = str + " is armstrong";
                } else
                    str1 = str + " is not armstrong";

                if (validnum == false)
                    str1 = " invalid number provided.";
                toClient.println(str1);
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