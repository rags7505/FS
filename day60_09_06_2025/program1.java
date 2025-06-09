package day60_09_06_2025;
import classes.TreeNode;
/*
In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. Scientists have recorded two types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how the colonization started, with the first zone established and then expanding into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows how zones were positioned relative to each other on the map, based on territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
3 2 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]

*/


import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int in[]=new int[n];
        int pre[]=new int[n];
        for(int i=0;i<n;i++) in[i]=sc.nextInt();
        for(int i=0;i<n;i++) pre[i]=sc.nextInt();
        sc.close();
        Map<Integer,Integer> mi=new HashMap<>();
        for(int i=0;i<n;i++) mi.put(in[i],i);
        TreeNode root=construct(pre,mi,0,n-1,0,n-1);
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
    public static TreeNode construct(int[] pre,Map<Integer,Integer> mi,int i,int m,int j,int n){
        if(i<0 || i>m || j<0 || j>n) return null;
        TreeNode root=new TreeNode(pre[j]);
        int idx=mi.get(pre[j]);
        root.left=construct(pre,mi,i,idx-1,j+1,j+idx-i);
        root.right=construct(pre,mi,idx+1,m,j+idx-i+1,n);
        return root;
    }
}
/* BEST CODE */
/* 
import java.util.*;
class Problem{
    static int preIndex=0;
    static HashMap<Integer,Integer>inMap=new HashMap<>();
    public static TreeNode buildTree(int in[],int pre[]){
        for(int i=0;i<in.length;i++){
            inMap.put(in[i],i);
        }
        return helper(pre,0,in.length-1);
    }
    public static TreeNode helper(int pre[],int is,int ie){
        if(is>ie)return null;
        int rootVal=pre[preIndex++];
        TreeNode root=new TreeNode(rootVal);
        int index=inMap.get(rootVal);
        root.left=helper(pre,is,index-1);
        root.right=helper(pre,index+1,ie);
        return root;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int in[]=new int[n];
        int pre[]=new int[n];
        for(int i=0;i<n;i++){
            in[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)pre[i]=sc.nextInt();
        TreeNode root=buildTree(in,pre);
        ArrayList<Integer>l=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            l.add(temp.val);
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }
        System.out.println(l);
    }
}
*/