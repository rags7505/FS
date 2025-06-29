package day40_12_05_2025;

/*
Siddu wants to get some rain coats before the rainy season begins. 
There are N rain coats in a store. He is provided an array price[], 
where price[i] represents the dollar price of the i-th rain coat. 

Siddu has D dollars to spend, and he wants to buy as many rain coats as 
he can, to give to his family and friends as gifts.

Your task is to assist Siddu in purchasing the most number of rain coats 
possible using D dollars.

Note: Siddu can purchase the rain coats in any order.

Input Format:
-------------
Line-1: Two space separated integers, N and D
Line-2: N space separated integers, prices of N rain coats.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 15
6 12 7 5 13 10 1

Sample Output-1:
----------------
3

Explanation:
------------
Siddu purchases Rain coats with price [1$, 5$, 7$] or [1$, 6$, 7$] or [1$, 5$, 6$].


Sample Input-2:
---------------
10 3
15 13 11 4 11 5 9 14 14 5

Sample Output-2:
----------------
0

Explanation:
------------
Siddu can't purchase any rain coat, because he has only 3$s with him.
*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n;i++){
            if(a[i]>d) break;
            ans++;
            d-=a[i];
        }
        System.out.println(ans);
    }
}
/* Claude other responses */
/*
// Alternative 1: Using Collections and enhanced for loop
class CollectionsSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        
        List<Integer> prices = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            prices.add(sc.nextInt());
        }
        sc.close();
        
        Collections.sort(prices);
        
        int count = 0;
        for(int price : prices) {
            if(price <= d) {
                d -= price;
                count++;
            } else {
                break;
            }
        }
        
        System.out.println(count);
    }
}

// Alternative 2: Using streams (Java 8+)
class StreamSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(prices);
        
        int[] budget = {d}; // Using array to make it effectively final
        int[] count = {0};
        
        Arrays.stream(prices)
              .takeWhile(price -> price <= budget[0])
              .forEach(price -> {
                  budget[0] -= price;
                  count[0]++;
              });
        
        System.out.println(count[0]);
    }
}

// Alternative 3: More readable version with better variable names
class ReadableSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRainCoats = scanner.nextInt();
        int budget = scanner.nextInt();
        
        int[] prices = new int[numberOfRainCoats];
        for(int i = 0; i < numberOfRainCoats; i++) {
            prices[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sort prices in ascending order to buy cheapest first
        Arrays.sort(prices);
        
        int rainCoatsPurchased = 0;
        int remainingBudget = budget;
        
        for(int price : prices) {
            if(price <= remainingBudget) {
                remainingBudget -= price;
                rainCoatsPurchased++;
            } else {
                break; // Can't afford any more rain coats
            }
        }
        
        System.out.println(rainCoatsPurchased);
    }
}

// Alternative 4: Using counting sort (if prices are small)
class CountingSortSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        
        // Assuming prices are reasonable (< 10000)
        int[] count = new int[10001];
        int maxPrice = 0;
        
        for(int i = 0; i < n; i++) {
            int price = sc.nextInt();
            count[price]++;
            maxPrice = Math.max(maxPrice, price);
        }
        sc.close();
        
        int rainCoats = 0;
        
        for(int price = 1; price <= maxPrice && price <= d; price++) {
            while(count[price] > 0 && price <= d) {
                d -= price;
                rainCoats++;
                count[price]--;
            }
        }
        
        System.out.println(rainCoats);
    }
}
 */