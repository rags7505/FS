/*
Write a Java program to convert a decimal number to binary using both
1. Recursive method
2. Iterative method

Implement the methods in Solution class and return the binary number.

Sample Input:
---------------
10

Sample Output:
------------------
Binary (Recursive): 1010
Binary (Iterative): 1010
*/

import java.util.Scanner;
class Solution {
  public static String decimalToBinaryRecursive(int n) {
      // Implement the method recursively
      if(n==0) return "";
      String s="";
      s=decimalToBinaryRecursive(n/2)+""+(n%2);
      return s;
  }

  public static String decimalToBinaryIterative(int n) {
      // Implement the method iteratively
      StringBuilder sb=new StringBuilder();
      while(n!=0){
          sb.insert(0,n%2);
          n/=2;
      }
      return sb.toString();
  }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int decimalNumber = sc.nextInt();
      sc.close();
      String binaryRecursive = decimalToBinaryRecursive(decimalNumber);
      String binaryIterative = decimalToBinaryIterative(decimalNumber);
      System.out.println("Binary (Recursive): " + binaryRecursive);
      System.out.println("Binary (Iterative): " + binaryIterative);
  }
}