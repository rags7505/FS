package day9_11_02_2025;
import classes.TreeNode;
/*
The Indian Army has established multiple military camps at strategic locations 
along the Line of Actual Control (LAC) in Galwan. These camps are connected in 
a hierarchical structure, with a main base camp acting as the root of the network.

To fortify national security, the Government of India has planned to deploy 
a protective S.H.I.E.L.D. that encloses all military camps forming the outer 
boundary of the network.

Structure of Military Camps:
    - Each military camp is uniquely identified by an integer ID.
    - A camp can have at most two direct connections:
        - Left connection → Represents a subordinate camp on the left.
        - Right connection → Represents a subordinate camp on the right.
    - If a military camp does not exist at a specific position, it is 
      represented by -1
	
Mission: Deploying the S.H.I.E.L.D.
Your task is to determine the list of military camp IDs forming the outer 
boundary of the military network. This boundary must be traversed in 
anti-clockwise order, starting from the main base camp (root).

The boundary consists of:
1. The main base camp (root).
2. The left boundary:
    - Starts from the root’s left child and follows the leftmost path downwards.
    - If a camp has a left connection, follow it.
    - If no left connection exists but a right connection does, follow the right connection.
    - The leftmost leaf camp is NOT included in this boundary.
3. The leaf camps (i.e., camps with no further connections), ordered from left to right.
4. The right boundary (in reverse order):
    - Starts from the root’s right child and follows the rightmost path downwards.
    - If a camp has a right connection, follow it.
    - If no right connection exists but a left connection does, follow the left connection.
    - The rightmost leaf camp is NOT included in this boundary.


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]


Sample Input-3:
---------------
1 2 3 -1 -1 -1 5 -1 6 7

Sample Output-3:
----------------
[1, 2, 7, 6, 5, 3]

*/
/*
test cases:
case =1
input =2 1 3 6 4 -1 9
output =[2, 1, 6, 4, 9, 3]

case =2
input =5 2 4 7 9 8 1
output =[5, 2, 7, 9, 8, 1, 4]

case =3
input =1
output =[1]

case =4
input =11 2 13 4 25 6 -1 -1 -1 7 18 9 10
output =[11, 2, 4, 7, 18, 9, 10, 6, 13]

case =5
input =1 2 4 3 5 6 9 12 8 14 11 7 22 19 13
output =[1, 2, 3, 12, 8, 14, 11, 7, 22, 19, 13, 9, 4]

case =6
input =5 -1 1 3 6
output =[5, 3, 6, 1]

case =7
input =11 8 6 1 7 5 16 3 20 18 14 22 10 4 2 17 15 19 12
output =[11, 8, 1, 3, 17, 15, 19, 12, 18, 14, 22, 10, 4, 2, 16, 6]

case =8
input =1 3 5 7 -1 -1 9 8 -1 -1 6 10 -1 13
output =[1, 3, 7, 8, 10, 13, 6, 9, 5]

case =9
input =1 -1 2 -1 3 -1 4 5 6 -1 7 8 -1 -1 9 10 11
output =[1, 9, 10, 11, 8, 6, 4, 3, 2]

case =10
input =1 2 -1 3 -1 4 -1 5 6 -1 7 8 -1 -1 9 10 11
output =[1, 2, 3, 4, 5, 7, 9, 10, 11]
 */
import java.util.*;
class program3 {
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
        while (j < n) {
            TreeNode cur = q.poll();
            if (l[j] != -1){
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
        List<Integer> l1=new ArrayList<>();
        if (root != null) {
            List<Integer> left = new ArrayList<>();
            left.add(root.val);
            getLeft(root.left, left);
            List<Integer> leaf = new ArrayList<>();
            getLeaf(root, leaf);
            List<Integer> right = new ArrayList<>();
            getRight(root.right, right);
            Collections.reverse(right);
            l1.addAll(left);
            l1.addAll(leaf);
            l1.addAll(right);
        }
        System.out.println(l1);
        sc.close();
    }
    public static void getRight(TreeNode root,List<Integer> l){
        if(root==null) return;
        if(root.left!=null || root.right!=null) l.add(root.val);
        if(root.right!=null) getRight(root.right,l);
        else if(root.left!=null) getRight(root.left,l);
    }
    public static void getLeaf(TreeNode root,List<Integer> l){
        if(root==null) return;
        if(root.left==null && root.right==null){
            l.add(root.val);
            return;
        }
        getLeaf(root.left,l);
        getLeaf(root.right,l);
    }

public static void getLeft(TreeNode root,List<Integer> l){
    if(root==null) return;
    if(root.left!=null || root.right!=null) l.add(root.val);
    if(root.left!=null) getLeft(root.left,l);
    else if(root.right!=null) getLeft(root.right,l);
}
}
