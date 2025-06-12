package Other_codes_Drives.copart_programs;
/*
 Question:9

Shells

Alan finds a large seashell on a seashore. He finds that it can be broken into two equal halves. Now he chooses one of the 
remaining shells and continues the breaking operation.

The operations are visualized in the form of a binary tree with all same sized pieces on the same level. Here, the original shell
is at the root node and the children are the 2 broken halves and so on.

If the it shell is broken, it can be chosen from a certain number of levels depending upon the previous choices of breaking the first
to (i-1)th shell.

Find and return the sum of all possible levels at which the ith shell can be broken.

Input Specification:
--------------------
input1: An integer i denoting the number of shelis to be broken.

Output Specification: 
---------------------
Return the sum of all possible levels at which the ith shell can be broken.

Example 1:

input1: 8

Output: 25


Explanation:
------------
Possible levels lie between 3 to 7.

Since on breaking the shells simultaneously from both the ses. 8 shells can be broken by the 3rd level and on breaking the shells 
from any of the one side (either left hand or right-hand side), we have to traverse till level 7 to break 8 shells.

Hence. 3+4+5+6+7 25. therefore. 25 is returned as the output.

Example 2:
----------
input1: 12

Output: 63

Explanation:
------------
Possible levels lie between 2 to 4.

Since on breaking the shells simultaneously from both the sides. 5 shells can be broken by the 2 level and on breaking the shells 
from any of the one side (either left hand or right-hand side) we have to traverse till level 4 to break 5 shells

Hence 2+3+4 9. therefore 9 is returned as the output

 */