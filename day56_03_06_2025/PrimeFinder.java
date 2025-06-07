/*
Write a Java program to find the nth prime number. 
The value of n should be input by the user.

Sample Input:
---------------
5

Sample Output:
-----------------
11
*/
import java.util.*;

class PrimeFinder {

    public static int findNthPrime(int n) {
        // Implement this method.
        int cnt=0;
        int i=2;
        while(cnt!=n){
            boolean prime=true;
            for(int k=2;k<i;k++){
                if(i%k==0){
                    prime=false;
                    break;
                }
            }
            if(prime) cnt++;
            if(cnt==n) return i;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int result = findNthPrime(n);
        System.out.println(result);
    }
}
