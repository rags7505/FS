package Other_codes_Drives.copart_programs;
/*
 Question 4 – Pizza Delivery Boy

Pizza Delivery Boy

A pizza delivery boy got X orders to be delivered on his first day at work. The position of X locations is given in (a, b) co‑ordinates, and the boy’s speed is given in units per minute.

Find the maximum of the total traveling time it would take from one place to another.

Note: Use Euclidean’s method to calculate the distance between two points. Euclidean Distance is defined as:


sqrt[(b2 - b1)^2 + (a2 - a1)^2]

Input Specification:
--------------------
 input1: Speed of Dan
 input2: Value of X
 input3: A 2‑D array consisting of (x, y) co‑ordinates of X locations

Output Specification:
---------------------
Return maximum traveling time among all the points. The answer should be rounded off to 6 decimal places.



Example 1:
----------
input1: 2
input2: 3
input3: [(0,0),(0,2),(2,0)]


Output: 1.414214

Explanation:
-------------
The maximum distance is between points (0,2) and (2,0), which is 2.828428.
Dan’s speed is 2, so time taken = 1.414214.



Example 2:
----------

input1: 4
input2: 4
input3: [(0,0),(-2,2),(2,2),(1,0)]


Output:
1.000000

Explanation:
------------
The maximum distance is between points (-2,2) and (2,2), which is 4. Dan’s speed is 4, so time taken = 1.000000.


 */