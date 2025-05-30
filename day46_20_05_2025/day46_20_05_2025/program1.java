package day46_20_05_2025;

/*
A binary word Bn is formed as follows:
    B[1] = "0"
    B[i+1] =  B[i] $ "1" $ reverse(complement(B[i])) for i > 1

where $ denotes the concatenation operation, reverse(complement(B)) returns 
the reversed word of complement(B), which perform 1's complement of B 
(0 changes to 1 and 1 changes to 0).

For example, the first 4 words in the above sequence are:

    B[1] = "0"
    B[2] = "011"
    B[3] = "0111001"
    B[4] = "011100110110001"

Return the Pth bit in B[N]. It is guaranteed that P is valid for the given N.

Input Format:
-------------
Line-1: Two space seperated integers represents N and P.

Output Format:
--------------
Return a bit (0 or 1).


Sample Input-1:
---------------
3 4

Sample Output-1:
----------------
1

Explanation:
------------
B[3] = "0111001" and 4th bit is 1.

Sample Input-2:
---------------
4 10

Sample Output-2:
----------------
1

Explanation:
-------------
B[4] = "011100110110001" and 10th bit is 1.

*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        sc.close();
        String prev="0";
        for(int i=2;i<=n;i++){
            String k=get(prev);
            prev=prev+"1"+k;
            if(prev.length()>=p) break;
        }
        System.out.println(prev.charAt(p-1));
        
    }
    public static String get(String k){
        StringBuilder sb=new StringBuilder();
        for(int i=k.length()-1;i>=0;i--){
            char c=k.charAt(i);
            sb.append(c=='1'?'0':'1');
        }
        return sb.toString();
    }
}
/* chatgpt and best approach */
/*
 private static char findBit(int n, int p) {
    if (n == 1) return '0';
    int mid = 1 << (n - 1); // mid = 2^(n-1)

    if (p == mid) return '1';
    else if (p < mid) return findBit(n - 1, p);
    else {
        char bit = findBit(n - 1, (1 << n) - p); // mirror
        return bit == '0' ? '1' : '0'; // complement
    }
}
 */