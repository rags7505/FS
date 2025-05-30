package day16_27_03_2025;
import classes.TreeNode;
/*
There are some pages in a website, each page links with atmost two other pages.
Each page displays a number on it. The complete website is given as binary tree 
using the level order insertion technique.

You need to return the number of pages where the number in the page is equal to 
the sum of the numbers of its descendants. A descendant refers to any page that 
is linked but lower down the tree stucture of the website, no matter how many 
levels lower.

Input Format:
-------------
Single line of comma separated integers, numbers displayed in web-pages as Tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
11 3 5 2 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
3 2 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
For the pages diplaying the number 0: The sum of descendants is 0,
since they have no descendant pages.

*/

import java.util.*;
class program3{
    static int cnt=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        if (s.length == 0) {
          sc.close();
          return;
        }
        int a[]=new int[s.length];
        for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(s[i]);
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(a[0]);
        q.add(root);
        int j=1;
        while (j < a.length) {
          TreeNode t = q.poll();
          if (a[j] != -1) {
            t.left = new TreeNode(a[j]);
            q.add(t.left);
          }
          j++;
          if (j < a.length && a[j] != -1) {
            t.right = new TreeNode(a[j]);
            q.add(t.right);
          }
          j++;
        }
        sc.close();
        traverse(root);
        System.out.println(cnt);
    }
    public static void traverse(TreeNode root){
        if(root==null) return;
        if(root.val==(sum(root.left)+sum(root.right))){
            cnt++;
        }
        traverse(root.left);
        traverse(root.right);
    }
    public static int sum(TreeNode t){
        if(t==null) return 0;
        return t.val+sum(t.left)+sum(t.right);
    }
}
