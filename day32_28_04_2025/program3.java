package day32_28_04_2025;
/*
You are given a crystal with an energy level n. Your goal is to discover all 
the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together
to recreate the original crystal.

Example 1:
---------
Input:
28

Output:
[[2, 14], [2, 2, 7], [4, 7]]

Example 2:
----------
Input:
23

Output:
[]



Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.
*/
import java.util.*;
class program3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    List<Integer> l = new ArrayList<>();
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        l.add(i);
        l.add(n / i);
      }
    }
    if (n % Math.sqrt(n) == 0) {
      l.add((int) Math.sqrt(n));
    }
    Collections.sort(l);
    List<List<Integer>> ans = new ArrayList<>();
    generate(0, ans, l, new ArrayList<>(), 1, n);
    System.out.println(ans);
  }

  public static void generate(int i, List<List<Integer>> ans, List<Integer> l, List<Integer> temp, int prod, int n) {
    if (i >= l.size()) {
      return;
    }
    if (prod >= n) {
      if (prod == n) {
        ans.add(new ArrayList<>(temp));
      }
      return;
    }
    prod *= l.get(i);
    temp.add(l.get(i));
    generate(i, ans, l, temp, prod, n);
    prod /= l.get(i);
    temp.remove(temp.size() - 1);
    generate(i+1, ans, l, temp, prod, n);
  }
}