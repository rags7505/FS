package day87_25_07_2025;
/*
Xavier working on bitwise operations on integer elements.
He is trying to find the maximum XOR value of two elements.
You will be given a list of integers elements list[],
Your task is to findout the maximum XOR value of two elements 
from the given list.

Input Format:
-------------
Line-1: An integer N, number of elements
Line-2: N space separated integers, Arrays of elements.

Output Format:
--------------
Print an integer, max value of XOR value of two elements.


Sample Input-1:
---------------
3
5 9 14

Sample Output-1:
----------------
12

Explanation:
------------
XOR of 5 and 9


Sample Input-2:
---------------
5
34 23 62 73 35

Sample Output-2:
----------------
119


Sample Input-3:
---------------
6
12 23 31 65 76 43

Sample Output-3:
----------------
106
*/
import java.util.*;
public class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sc.close();
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max=Math.max(max,a[i]^a[j]);
            }
        }
        System.out.println(max);
    }
}
/* chatgpt */
/*
import java.util.*;

public class MaxXORValue {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2]; // 0 and 1
    }

    // Insert number into the trie
    private static void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    // Find max XOR of num with elements in trie
    private static int findMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.child[toggledBit] != null) {
                maxXOR |= (1 << i);
                node = node.child[toggledBit];
            } else {
                node = node.child[bit];
            }
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] arr = new int[n];
        TrieNode root = new TrieNode();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            insert(root, arr[i]);  // Insert each number into the Trie
        }

        int maxResult = 0;

        // Find max XOR for each number
        for (int i = 0; i < n; i++) {
            maxResult = Math.max(maxResult, findMaxXOR(root, arr[i]));
        }

        // Output
        System.out.println(maxResult);
    }
}

*/