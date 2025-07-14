package day80_14_07_2025;
/*
Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.

Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid
*/
import java.util.*;
class program5{
    public static boolean check4(String s){
        String a[]=s.split("\\.");
        if (a.length != 4) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() == 0) return false;
            if (a[i].length() == 1) continue;
            if (a[i].charAt(0) == '0')
                return false;
            if (a[i].length() > 3)
                return false;
            for (char c : a[i].toCharArray()) {
                if (c < '0' || c > '9') return false;
            }
            int num = Integer.parseInt(a[i]);
            if (num > 255 || num < 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean check6(String s){
        String a[]=s.split(":");
        if(a.length!=8) return false;
        String h="abcdefABCDEF1234567890";
        for(String i:a){
            if(i.length()==0 || i.length()>4) return false;
            for(char c:i.toCharArray()){
                if(h.indexOf(c)==-1) return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1 = sc.next();
        sc.close();
        if(check4(s1)){
            System.out.println("Type-I");
        }
        else if(check6(s1)){
            System.out.println("Type-II");
        }
        else{
            System.out.println("Invalid");
        }
    }
}