package day4_30_01_2025;

/*
Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

Input Format:
---------------
A String, IPAddress
An integer, CIDR

Output Format:
---------------
Space separated IP addresses, netwrok IP and broadcast IP.


Sample Input-1:
-----------------
192.168.1.10
24

Sample Output-1:
------------------
192.168.1.0 192.168.1.255


Sample Input-2:
-----------------
192.0.2.1
24

Sample Output-2:
------------------
192.0.2.0 192.0.2.255
*/
import java.util.*;
import java.net.*;
import java.nio.*;
class CNprogram2{
    public static void main (String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        String ipp=sc.next();
        int cidr=sc.nextInt();
        int ip = ByteBuffer.wrap(InetAddress.getByName(ipp).getAddress()).getInt();
        int mask= 0xffffffff << (32-cidr);
        int network=ip&mask;
        int broadcast=network | ~mask;
        System.out.print(ipadd(network) + " " + ipadd(broadcast));
        sc.close();
    }
    public static String ipadd(int ip){
        int mask= ip;
        return String.format("%d.%d.%d.%d",
                        (mask>>24)&0xff,(mask>>16)&0xff,(mask>>8)&0xff,
                        (mask)&0xff);
    }
}
