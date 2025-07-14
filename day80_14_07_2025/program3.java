package day80_14_07_2025;
/*
Mr Saurabh is given a list of words.
Your task is to help Mr Saurabh to find the size of largest group

A group is formed using the following rules:
- Pick one smallest word (in length) and form a group with this word
  (if it is not part of any other group yet)
- Add a letter at any place in the word without changing the relative order 
  of the letters in it, and if it forms a word which is existing in the list[],
  then add the word to the group.
- Repeat the above two steps, till all the words in the list are part of groups.

NOTE:You move form more than one group.

Input Format:
-------------
Space separated words, wordsList[].

Output Format:
--------------
Print an integer result


Sample Input-1:
---------------
many money n an mony any one mone on

Sample Output-1:
----------------
5

Explanation:
------------
the words group is : [n, on, one, mone, money]


Sample Input-2:
---------------
a ab abb babb abab baba bab abbaa

Sample Output-2:
----------------
4
*/
/* chatgpt */
import java.util.*;
public class program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] wordsList = sc.nextLine().split(" ");
        System.out.println(largestGroupSize(wordsList));
        sc.close();
    }

    public static int largestGroupSize(String[] wordsList) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(wordsList));
        Map<String, Integer> memo = new HashMap<>();
        int maxGroupSize = 0;
        
        // Try starting from each word to find the longest possible chain
        for (String word : wordsList) {
            int chainLength = findLongestChain(word, wordsSet, memo);
            maxGroupSize = Math.max(maxGroupSize, chainLength);
        }
        
        return maxGroupSize;
    }

    private static int findLongestChain(String word, Set<String> wordsSet, Map<String, Integer> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        
        int maxChain = 1; // Current word counts as 1
        
        // Try adding each character at each position to form longer words
        for (int i = 0; i <= word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = word.substring(0, i) + c + word.substring(i);
                if (wordsSet.contains(newWord) && newWord.length() == word.length() + 1) {
                    int chainLength = 1 + findLongestChain(newWord, wordsSet, memo);
                    maxChain = Math.max(maxChain, chainLength);
                }
            }
        }
        
        memo.put(word, maxChain);
        return maxChain;
    }
}