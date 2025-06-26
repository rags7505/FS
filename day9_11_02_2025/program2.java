package day9_11_02_2025;
import classes.TreeNode;
/*
A software development company is designing a smart home automation 
system that uses sensor networks to monitor and control different devices 
in a house. The sensors are organized in a hierarchical structure, where each 
sensor node has a unique ID and can have up to two child nodes (left and right).

The company wants to analyze the left-most sensors in the system to determine
which ones are critical for detecting environmental changes. The hierarchy of 
the sensors is provided as a level-order input, where missing sensors are 
represented as -1.

Your task is to build the sensor network as a binary tree and then determine 
the left-most sensor IDs at each level.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
A list of integers representing the left-most sensor IDs at each level


Sample Input-1:
---------------
1 2 3 4 -1 -1 5

Sample Output-1:
----------------
[1, 2, 4]



Sample Input-2:
---------------
3 2 4 1 5

Sample Output-2:
----------------
[3, 2, 1]
*/
import java.util.*;
public class program2 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s[]=sc.nextLine().split(" ");
    int n=s.length;
    int[] l=new int[n];
    for(int i=0;i<n;i++) l[i]=Integer.parseInt(s[i]);
    TreeNode root = new TreeNode(l[0]);
    int j = 1;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty() && j < n) {
      TreeNode cur = q.poll();
      if (l[j] != -1) {
        cur.left = new TreeNode(l[j]);
        q.add(cur.left);
      }
      j++;
      if (j < n && l[j] != -1) {
        cur.right = new TreeNode(l[j]);
        q.add(cur.right);
      }
      j++;
    }
    q.clear();
    List<Integer> l1=new ArrayList<>();
    dfs(root,l1,0);
    System.out.println(l1);
    sc.close();
  }
  public static void dfs(TreeNode root,List<Integer> l1,int depth){
      if(root==null) return;
      if(depth==l1.size()) l1.add(root.val);
      dfs(root.left,l1,depth+1);
      dfs(root.right,l1,depth+1);
  }
}
