package day60_09_06_2025;
import classes.TreeNode;

/*
Galactic Communication Network
------------------------------
In a distant galaxy, an ancient civilization built a hierarchical communication network of interconnected relay stations. The structure of this network can be reconstructed using two ancient data logs:

Beacon Activation Order (analogous to in-order traversal)
Final Signal Sent Order (analogous to post-order traversal)
Using these logs, we can reconstruct the original relay network and process queries about signals reaching specific hierarchical levels.

Given the Beacon Activation Order and the Final Signal Sent Order of a galactic communication network, reconstruct the relay network. After reconstructing the hierarchy, and the output should list the relay stations in the order they appear in a level-wise transmission sequence.

Input Format:
-------------
An integer N representing the number of relay stations in the network.
A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).

Output Format:
--------------
For each query, print the relay stations in order of their signal transmissions within the given depth range

Sample Input:
-------------
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
Sample Output:
---------------
[1, 2, 3, 4, 5, 6, 7]


Explanation:
The logs correspond to the following hierarchical relay network:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
The level order is : 1 2 3 4 5 6 7 
*/


import java.util.*;
class program2{
    static int posIndex;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int in[]=new int[n];
        int pos[]=new int[n];
        for(int i=0;i<n;i++) in[i]=sc.nextInt();
        for(int i=0;i<n;i++) pos[i]=sc.nextInt();
        sc.close();
        Map<Integer,Integer> mi=new HashMap<>();
        posIndex=n-1;
        for(int i=0;i<n;i++) mi.put(in[i],i);
        TreeNode root=construct(pos,mi,0,n-1);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            l.add(cur.val);
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
        System.out.println(l);
    }
    public static TreeNode construct(int[] pos,Map<Integer,Integer> mi,int i,int m){
        if(i>m) return null;
        int root_val=pos[posIndex--];
        TreeNode root=new TreeNode(root_val);
        int idx=mi.get(root_val);
        root.right=construct(pos,mi,idx+1,m);
        root.left=construct(pos,mi,i,idx-1);
        return root;
    }
}