package day41_13_05_2025;
/*
Umesh is a Mathematician,
He is given a task to his student Shanker, 
There are N coins in a row, indexed from 0 to N-1, intially all the coins are 
facing "tail". And Umesh has given him a final State-to-Achieve.

Shanker can achieve the final state by doing a swap operation as follows:
    - Shanker can choose any index i, 
    - all the coins has to be swap their faces, from "head" to "tail" 
    or "tail to "head" from index 'i' to 'N-1'.

Shanker is given a binary string S, State-to-Achieve contains [0,1] only. 
"tail" indicates with '0' and "head" indicates with '1'

Please help Shanker to find the minimum number of swap operations required 
to reach State-to-Achieve.


Input Format:
-------------
A String S, final State-to-Achieve.

Output Format:
--------------
Print an integer, minimum number of swap operations.


Sample Input-1:
---------------
10111010

Sample Output-1:
----------------
6

Explanation: 
------------
Initial configuration "00000000".
swap from the first coin: "00000000" -> "11111111"
swap from the second coin: "11111111" -> "10000000"
swap from the third coin: "10000000" -> "10111111"
swap from the sixth coin: "10111111" -> "10111000"
swap from the seventh coin: "10111000" -> "10111011"
swap from the eighth coin: "10111011" -> "10111010"
A total of 6 swap operations required.


Sample Input-2:
---------------
11111

Sample Output-2:
----------------
1

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        int ans=0,flip=0;
        for(char c:s.toCharArray()){
            if(c=='0' && flip==1){
                ans++;
                flip=0;
            }
            else if(c=='1' && flip==0){
                ans++;
                flip=1;
            }
        }
        System.out.println(ans);
    }
}
/* claude other responses */
/*
// Alternative 1: More readable version with better variable names
class ReadableSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String targetState = sc.next();
        sc.close();
        
        int operations = 0;
        boolean isFlipped = false; // Current state: false = normal, true = flipped
        
        for(char coin : targetState.toCharArray()) {
            // What we expect based on current flip state
            char expectedValue = isFlipped ? '1' : '0';
            
            // If current coin doesn't match expected, we need to flip
            if(coin != expectedValue) {
                operations++;
                isFlipped = !isFlipped; // Toggle flip state
            }
        }
        
        System.out.println(operations);
    }
}

// Alternative 2: Using XOR logic (more concise)
class XORSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        int operations = 0;
        int currentFlipState = 0; // 0 = normal, 1 = flipped
        
        for(char c : s.toCharArray()) {
            int targetBit = c - '0'; // Convert '0'/'1' to 0/1
            
            // If current bit doesn't match what we expect, flip
            if(targetBit != currentFlipState) {
                operations++;
                currentFlipState = 1 - currentFlipState; // Toggle between 0 and 1
            }
        }
        
        System.out.println(operations);
    }
}

// Alternative 3: Counting consecutive groups approach
class GroupCountSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        if(s.length() == 0) {
            System.out.println(0);
            return;
        }
        
        int operations = 0;
        char currentGroup = '0'; // We start with all 0s
        
        for(char c : s.toCharArray()) {
            if(c != currentGroup) {
                operations++;
                currentGroup = c;
            }
        }
        
        System.out.println(operations);
    }
}

// Alternative 4: Simulation approach (less efficient but more intuitive)
class SimulationSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        sc.close();
        
        int n = target.length();
        char[] current = new char[n];
        Arrays.fill(current, '0'); // Initialize all to '0' (tails)
        
        int operations = 0;
        
        // Find leftmost mismatch and flip from there
        for(int i = 0; i < n; i++) {
            if(current[i] != target.charAt(i)) {
                // Flip from position i to end
                for(int j = i; j < n; j++) {
                    current[j] = (current[j] == '0') ? '1' : '0';
                }
                operations++;
            }
        }
        
        System.out.println(operations);
    }
}

// Alternative 5: Mathematical approach - count transitions
class TransitionCountSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        // Count number of times the target state changes
        // This equals the number of operations needed
        int transitions = 0;
        char previousState = '0'; // We start with all 0s
        
        for(char currentState : s.toCharArray()) {
            if(currentState != previousState) {
                transitions++;
                previousState = currentState;
            }
        }
        
        System.out.println(transitions);
    }
}
 */