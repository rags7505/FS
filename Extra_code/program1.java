package Extra_code;

/* Extinct Language Word Checker
Problem Description
"Juniors Network" Cartoon Channel is the favorite channel of all the kids in the city.
As it is vacation time, the channel introduced several new segments to engage the kids in a more creative manner.
"Fun with Words" is one such activity involving English alphabets, where school kids were invited to participate.

Today on the show, the show host Santra briefed the kids about extinct languages and modern languages in the World.
 Extinct languages are languages that are no longer in use. 
 Such languages were widely used before and no one could have ever imagined that they will become extinct at some point. 
 On the happy side of things, a language may be extinct, but some of its words may continue to be used in other languages.

Santra now has acquired a dictionary of N words of an extinct language. She also knows K phrases used in modern languages. 
For each of the words of the forgotten language, the kids are to determine whether the word is still in use in any of these K modern phrases or not.
 Help them with the activity by writing a block of code.

Input Format
  First line: Two space-separated positive integers N and K.
  Second line: N strings denoting a dictionary of the extinct language.
  Next K lines: Each line starts with one positive integer L denoting the number of words in the corresponding phrase in modern languages. 
  The integer is followed by L strings (not necessarily distinct) denoting the phrase.
Output Format
  containing N tokens (space-separated): if the i-th word of the dictionary exists in at least one phrase in modern languages, then output "Yes" (without quotes) as the i-th token, otherwise "No" (without quotes).
Sample Testcase-1
  Input:
  3 2
  piygu ezyfo rzotm
  1 piygu
  6 tefwz tefwz piygu ezyfo tefwz piygu

  Output:
  Yes Yes No

  Sample Testcase-2
  Input:
  2 2
  werft qwefr
  2 fgrhr hrhrh
  3 werft qwerfr rtygre

  Output:
  Yes No
*/
import java.util.*;
public class program1{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    String s[] = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }
    HashSet<String> hs = new HashSet<>();
    for (int i = 0; i < k; i++) {
      int p = sc.nextInt();
      String s1[] = new String[p];
      for (int j = 0; j < p; j++) {
        s1[i] = sc.next();
      }
      hs.addAll(Arrays.asList(s1));
    }
    sc.close();
    for (String i : s) {
      if (hs.contains(i)) {
        System.out.print("Yes ");
      }
      else {
        System.out.print("No ");
      }
    }
  }
}