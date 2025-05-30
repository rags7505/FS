package day33_29_04_2025;
/*
Weekend Venkat Rao visits a nightclub where a game is being organized to win 
as much gold as possible.

He starts the game with:
	- An initial amount of money X.
	- An initial gold count of 0.
	- A list of N coupons, where each coupon has a value coupon[i].

Game Rules:
Venkat Rao can choose to play any coupon at most once, and in any order. 
For each coupon, he has two options:

1. Play as Head: If his current amount is greater than or equal to coupon[i], 
he can: 
	- Spend coupon[i] amount of money.
	- Gain 1 gold.

2. Play as Tail: If he has at least 1 gold, he can:
	- Spend 1 gold.
	- Gain coupon[i] amount of money.

The goal is to maximize the total gold Venkat Rao can earn after playing zero 
or more coupons.

Input Format:
-------------
Line-1: Two integers N and X, N number of coupons, and intial amount X.
Line-2: N space separated integers, amounts on the coupons. 

Output Format:
--------------
Print an integer, maximum gold earned by Weekend Venkat Rao.


Sample Input-1:
---------------
2 75
50 100


Sample Output-1:
----------------
1

Explanation:
-------------
Play the 0 coupon (50) to head, your amount becomes 50 and gold becomes 1.
There is no need to play the 1 coupon since you cannot play it head to add to your gold.
	

Sample Input-2:
---------------
4 50
25 50 75 100

Sample Output-2:
----------------
2

Explanation:
-------------
Play the coupons in this order to get a gold of 2units:
- Play the 0 coupon (25) to head, your amount becomes 25 and gold becomes 1.
- Play the 3 coupon (100) to tail, your amount becomes 125 and gold becomes 0.
- Play the 1 coupon (50) to head, your amount becomes 75 and gold becomes 1.
- Play the 2 coupon (75) to head, your amount becomes 0 and gold becomes 2.
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int amt=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
	      sc.close();
        Arrays.sort(a);
        int ans=0;
        int i=0,j=n-1,gold=0;
        while(i<=j){
            while(i<=j && a[i]<=amt){
                amt-=a[i];
                gold++;
                i++;
            }
            ans=Math.max(ans,gold);
            if(i>j) break;
            if(gold>0){
                amt+=a[j];
                j--;
                gold--;
            }
        }
        System.out.println(ans);
    }
}
/* same but alternate */
/*
 * import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int amt=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        int ans=0;
        int i=0,j=n-1,gold=0;
        while(i<=j){
            if( a[i]<=amt){
                amt-=a[i];
                gold++;
                i++;
            }
            else if(gold>0){
                amt+=a[j];
                j--;
                gold--;
            }
            else break;
            ans=Math.max(ans,gold);
        }
        System.out.println(ans);
    }
}
 */