package day42_14_05_2025;
/*
 Mr NOkayya is AI developer, He is given a dictionary, he want to implement a 
an Word-Corrector application that checks user-word and corrects it.

For a given user-word, the Word-Corrector handles two types of validations:

1) If the user-word matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
    Ex-1: dict = ["kmit"], user-word = "KmIt": word-corrector = "kmit"
	Ex-2: dict = ["Kmit"], user-word = "kmit": word-corrector = "Kmit"
	Ex-3: dict = ["kmit"], user-word = "kmit": word-corrector = "kmit"
	
2) If after replacing the vowels of the user-word with any vowel individually,
it matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
	Ex-1: dict = ["KmIt"], user-word = "kmet": word-corrector = "KmIt"
	Ex-2: dict = ["KmIt"], user-word = "kmmit": word-corrector = "" (no match)
	Ex-3: dict = ["KmIt"], user-word = "kit": word-corrector = "" (no match)

In addition to the above conditions, the word-corrector app works
with the following precedence rules:
 - When the user-word exactly matches a word in the dictionary (case-sensitive), 
    you should return the same word back.
 - When the user-word matches a word up to validation-1, 
    you should return the first such match in the dictionary.
 - When the user-word matches a word up to validation-2, 
    you should return the first such match in the dictionary.
 - If the user-word has no matches in the dictionary, 
    you should return the empty string.

You are given some user-words[], return a list of words result[], 
where result[i] is the corrected words by the Word-Corrector app for 
user-word = user-words[i].


Input Format:
-------------
Line-1: comma separated strings, dictionary[].
Line-2: comma separated strings, user-words[].

Output Format:
--------------
List of corrected user-words[] by Word-Corrector app.


Sample Input-1:
---------------
LiTe,lite,bare,Bare
lite,Lite,LiTe,Bare,BARE,Bear,bear,leti,leet,leto

Sample Output-1:
----------------
[lite, LiTe, LiTe, Bare, bare, , , LiTe, , LiTe]


Sample Input-2:
---------------
kmit,ngit,kmec
KmOT,NHIT,KMIC

Sample Output-2:
----------------
[kmit, , kmec]


 */

/*Chatgpt */
/*
import java.util.*;
class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dict = sc.nextLine().split(",");
        String[] userWords = sc.nextLine().split(",");
        sc.close();
        List<String> result = new ArrayList<>();
        
        for (String userWord : userWords) {
            String correctedWord = correctWord(dict, userWord);
            result.add(correctedWord);
        }
        
        System.out.println(result);
    }
    
    private static String correctWord(String[] dict, String userWord) {
        // Check for exact match
        for (String word : dict) {
            if (word.equals(userWord)) {
                return word;
            }
        }
        
        for (String word : dict) {
            if (word.equalsIgnoreCase(userWord)) {
                return word;
            }
        }
        
        for (String word : dict) {
            if (isVowelReplacementMatch(word, userWord)) {
                return word;
            }
        }
        
        return "";
    }

    private static boolean isVowelReplacementMatch(String dictWord, String userWord) {
        if (dictWord.length() != userWord.length()) {
            return false;
        }
        
        for (int i = 0; i < dictWord.length(); i++) {
            char dictChar = dictWord.charAt(i);
            char userChar = userWord.charAt(i);
            if(Character.toLowerCase(userChar)==Character.toLowerCase(dictChar)){
                continue;
            }
            if (isVowel(dictChar) && isVowel(userChar)) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
    */

    import java.util.*;
    class program2{
        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            String dict[]=sc.next().split(",");
            sc.nextLine();
            String user[]=sc.next().split(",");
            sc.close();
            List<String> l=new ArrayList<>();
            for(String s:user){
                String k=check(dict,s);
                l.add(k);
            }
            System.out.println(l);
        }
        public static String check(String d[],String s){
            for(String i:d){
                if(i.equals(s)) return i;
            }
            for(String i:d){
                if(i.equalsIgnoreCase(s)) return i;
            }
            for(String i:d){
                if(can(i,s)) return i;
            }
            return "";
        }
        public static boolean can(String i,String s){
            if(i.length()!=s.length()) return false;
            for(int k=0;k<i.length();k++){
                if(Character.toLowerCase(i.charAt(k))==Character.toLowerCase(s.charAt(k))) continue;
                if("aeiouAEIOU".indexOf(i.charAt(k))!=-1 && "aeiouAEIOU".indexOf(s.charAt(k))!=-1) continue;
                return false;
            }
            return true;
        }
    }
/* claude other responses */
/*
package day42_14_05_2025;

import java.util.*;


 * Word-Corrector Application
 * 
 * This application implements a spell checker that validates user words against a dictionary
 * using three levels of matching:
 * 1. Exact match (case-sensitive)
 * 2. Case-insensitive match
 * 3. Vowel replacement match (vowels can be substituted)
 
class WordCorrector {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read dictionary and user words
        String[] dictionary = sc.nextLine().split(",");
        String[] userWords = sc.nextLine().split(",");
        sc.close();
        
        // Process each user word
        List<String> results = new ArrayList<>();
        for (String userWord : userWords) {
            String correctedWord = correctWord(dictionary, userWord);
            results.add(correctedWord);
        }
        
        // Output results
        System.out.println(results);
    }
    

      Corrects a user word based on dictionary matches
     Follows precedence: exact match -> case-insensitive -> vowel replacement
     
    private static String correctWord(String[] dictionary, String userWord) {
        // Level 1: Check for exact match (case-sensitive)
        for (String dictWord : dictionary) {
            if (dictWord.equals(userWord)) {
                return dictWord;
            }
        }
        
        // Level 2: Check for case-insensitive match
        for (String dictWord : dictionary) {
            if (dictWord.equalsIgnoreCase(userWord)) {
                return dictWord;
            }
        }
        
        // Level 3: Check for vowel replacement match
        for (String dictWord : dictionary) {
            if (isVowelReplacementMatch(dictWord, userWord)) {
                return dictWord;
            }
        }
        
        // No match found
        return "";
    }
    
    // 
    //   Checks if two words match when vowels can be replaced with any other vowel
    //   Words must be same length and non-vowel characters must match exactly (case-insensitive)
    //  
    private static boolean isVowelReplacementMatch(String dictWord, String userWord) {
        // Words must be same length
        if (dictWord.length() != userWord.length()) {
            return false;
        }
        
        // Check each character position
        for (int i = 0; i < dictWord.length(); i++) {
            char dictChar = dictWord.charAt(i);
            char userChar = userWord.charAt(i);
            
            // If characters match (case-insensitive), continue
            if (Character.toLowerCase(dictChar) == Character.toLowerCase(userChar)) {
                continue;
            }
            
            // If both are vowels, they can be substituted
            if (isVowel(dictChar) && isVowel(userChar)) {
                continue;
            }
            
            // Characters don't match and can't be substituted
            return false;
        }
        
        return true;
    }
    

    //   Checks if a character is a vowel (case-insensitive)
    
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

Test Cases:

Sample Input-1:
LiTe,lite,bare,Bare
lite,Lite,LiTe,Bare,BARE,Bear,bear,leti,leet,leto

Expected Output-1:
[lite, LiTe, LiTe, Bare, bare, , , LiTe, , LiTe]

Explanation:
- "lite" -> exact match with "lite"
- "Lite" -> case-insensitive match, returns first match "LiTe"
- "LiTe" -> exact match with "LiTe"
- "Bare" -> exact match with "Bare"
- "BARE" -> case-insensitive match with "bare"
- "Bear" -> no match (consonants don't match)
- "bear" -> no match (consonants don't match)
- "leti" -> vowel replacement match with "LiTe" (e->i, i->e)
- "leet" -> no match (wrong length or pattern)
- "leto" -> vowel replacement match with "LiTe" (e->i, o->e)

Sample Input-2:
kmit,ngit,kmec
KmOT,NHIT,KMIC

Expected Output-2:
[kmit, , kmec]

Explanation:
- "KmOT" -> vowel replacement match with "kmit" (O->i)
- "NHIT" -> no match (consonants don't match)
- "KMIC" -> vowel replacement match with "kmec" (I->e)
*/