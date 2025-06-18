package day64_17_06_2025;
/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/
/* chatgpt */
import java.util.*;

public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] releases = sc.nextLine().split(" ");
        sc.close();

        String latest = releases[0];
        for (int i = 1; i < releases.length; i++) {
            if (compareVersions(releases[i], latest) > 0) {
                latest = releases[i];
            }
        }

        // Remove any unnecessary trailing zeros
        System.out.println(trimTrailingZeros(latest));
    }

    // Compare two versions: returns positive if v1 > v2, negative if v1 < v2, 0 if equal
    static int compareVersions(String v1, String v2) {
        String[] parts1 = v1.split("-");
        String[] parts2 = v2.split("-");
        int maxLen = Math.max(parts1.length, parts2.length);

        for (int i = 0; i < maxLen; i++) {
            int num1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int num2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

            if (num1 != num2) {
                return num1 - num2;
            }
        }
        return 0; // equal
    }

    // Remove trailing zeros from version representation
    static String trimTrailingZeros(String version) {
        String[] parts = version.split("-");
        int end = parts.length - 1;
        while (end > 0 && parts[end].equals("0")) {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= end; i++) {
            if (i > 0) sb.append("-");
            sb.append(parts[i]);
        }
        return sb.toString();
    }
}
