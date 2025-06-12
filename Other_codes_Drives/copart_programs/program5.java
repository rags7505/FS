package Other_codes_Drives.copart_programs;
/*
 Question 5 – Hierarchy


Hierarchy

You are given a string(S) of digits. All the digits are 0s or 1s. Each 0 represents a dead node and each 1 represents an alive node. Assuming that the 0ᵗʰ node in the string is the oldest, a family tree is created in the following manner:

 -> 0ᵗʰ node is the root
 ->Every alive node must have 2 children
 -> Dead nodes cannot have children
 ->The iᵗʰ node in the string is elder than (i+1)ᵗʰ node, and any node is made the child of the eldest node alive with 0 or 1 children.
 ->In the family tree, the elder child of a node is on the left and younger child on the right
 ->If no node is alive at any layer, then the construction is stopped and this tree is accepted as the final family tree.

Your task is to find the height of the family tree for a given string S.



Input Specification:
--------------------
 input1: String of 0s and 1s

Output Specification:
---------------------
Return H, Height of the family tree.



Example 1:
----------
input1: 111

Output: 1

Explanation:
------------
Family tree:


    1
   / \
  1   1


H = 1



Example 2:
----------
input1: 1001

Output: 1

Explanation:
------------
Family tree:H = 1,the Last node in the string cannot be placed as both the node in the bottom-most layer are dead. 


    1
   / \
  0   0


 */