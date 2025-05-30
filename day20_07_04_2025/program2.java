package day20_07_04_2025;

/*
Imagine you're designing a sequence of signals for a high-tech robot. 
The robot receives its instructions as list of integers, where each integer 
represents one byte of the command data. A complete command can be composed of 
1 to 4 bytes, following these strict rules:

- For a 1-byte command, the first bit must be 0, followed by the command's code.
- For a multi-byte command (with n bytes), the first byte starts with n 
  consecutive 1’s, immediately followed by a 0. Each of the following n – 1 bytes 
  must begin with the bit pattern 10.

This is how the robot interprets the byte sequences:

 Number of Bytes   |        Robot Signal Sequence
				   |              (binary)
-------------------+---------------------------------------
		1          |   0xxxxxxx
		2          |   110xxxxx 10xxxxxx
		3          |   1110xxxx 10xxxxxx 10xxxxxx
		4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Here, each x represents a bit that can be either 0 or 1.

Note: Only the least significant 8 bits of each integer in the input list of 
integers are used, meaning each integer stands for exactly one byte of data.

Your challenge is to verify whether the provided sequence of robot instructions 
strictly follows the defined encoding rules.

Example 1:
----------
Input=
197 130 1

Output=
true

Explanation: 
- The array corresponds to the binary sequence: 11000101 10000010 00000001.  
- This is a valid encoding: a 2-byte command (11000101 10000010) followed by a 
  valid 1-byte command (00000001).

Example 2:
----------
Input=
234 140 4

Output=
false

Explanation:
- The array corresponds to the binary sequence: 11101011 10001100 00000100.  
- The first three bits of the first byte are 1’s with a following 0, indicating 
  a 3-byte command. The second byte starts correctly with 10, but the third byte 
  does not begin with 10, so the command sequence is invalid.

Constraints:

- 1 <= instructions.length <= 2 * 10^4
- 0 <= instruction <= 255

*/


import java.util.*;
public class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        for(int i=0;i<s.length;i++){
            s[i]=Integer.toBinaryString(Integer.parseInt(s[i]));
            if(s[i].length()!=8){
                StringBuilder sb=new StringBuilder(s[i]);
                while(sb.length()!=8) sb.insert(0,'0');
                s[i]=sb.toString();
            }
        }
        System.out.print(check(s));
        sc.close();
    }
    public static boolean check(String[] s){
        int i=0;
        while(i<s.length){
            int j=0,cnt=0;
            while(j<8 && s[i].charAt(j)=='1'){
                j++;
                cnt++;
            }
            if(cnt==1 || cnt==8) return false;
            int c=cnt-1;
            i++;
            String s1="10";
            while(i<s.length && c>0){
                if(!s[i].startsWith(s1)) return false;
                c--;
                i++;
            }
            if(c>0) return false;
        }
        return true;
    }
}
