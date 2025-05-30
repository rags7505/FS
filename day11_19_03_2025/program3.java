package day11_19_03_2025;
import classes.TreeNode;
/*
Bubloo is working with computer networks, where servers are connected 
in a hierarchical structure, represented as a Binary Tree. Each server (node) 
is uniquely identified by an integer value.

Bubloo has been assigned an important task: find the shortest communication 
path (in terms of network hops) between two specific servers in the network.

Network Structure:
------------------
The network of servers follows a binary tree topology.
Each server (node) has a unique identifier (integer).
If a server does not exist at a certain position, it is represented as '-1' (NULL).

Given the root of the network tree, and two specific server IDs (E1 & E2), 
determine the minimum number of network hops (edges) required to 
communicate between these two servers.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
4 8

Sample Output-1:
----------------
4

Explanation:
------------
The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]


Sample Input-2:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
6 6

Sample Output-2:
----------------
0

Explanation:
------------
No edegs between 6 and 6.
*/
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int a[]=new int[s.length];
        for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(s[i]);
        int st=sc.nextInt();
        int end=sc.nextInt();
        if(st==end){
          System.out.println(0);
            sc.close();
            return;
        }
        TreeNode root=new TreeNode(a[0]);
        int j=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(j<a.length){
            TreeNode t=q.poll();
            if(a[j]!=-1){
                t.left=new TreeNode(a[j]);
                q.add(t.left);
            }
            j++;
            if(j<a.length && a[j]!=-1){
                t.right=new TreeNode(a[j]);
                q.add(t.right);
            }
            j++;
        }
        TreeNode lcaNode=LCA(root,st,end);
        int depth1=find(lcaNode,st,0);
        int depth2=find(lcaNode,end,0);
        System.out.println(depth1 + depth2);
        sc.close();
    }
    public static int find(TreeNode root, int el, int d) {
    if (root == null) return -1;
    if (root.val == el) return d;
    
    int left = find(root.left, el, d + 1);
    if (left != -1) return left;

    int right = find(root.right, el, d + 1);
    return right; 
}
    public static TreeNode LCA(TreeNode root,int st,int end){
        if(root==null || root.val==st || root.val==end) return root;
        TreeNode r1=LCA(root.left,st,end);
        TreeNode r2=LCA(root.right,st,end);
        if(r1!=null && r2!=null) return root;
        if(r1==null && r2!=null) return r2;
        return r1;
    }
}
