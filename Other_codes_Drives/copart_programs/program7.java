package Other_codes_Drives.copart_programs;
/*
 Question 7 

Problem: Honey Madness

Honey Madness

Congratulations! You have been born as a honey bee. The good part is that you do not have to study. The bad part is that you have to work all day, every day to collect honey. You live in a honey home (not Honeycomb).

You have to collect honey from various flowers daily and submit it to various honeycombs spread across the area and return home by a specific time. Your task is to collect as much honey as possible by the allocated time and submit it to the honeycombs.

Each flower has 1 unit of honey and you can only carry 1 unit of honey at a time. Also, covering 1 unit distance requires 1 unit of time. Distance is calculated using Euclidean distance formula.

Find out the maximum units of honey you can collect.

Input Specification:
---------------------
* input1: Number of flowers.
* input2: Number of honeycombs.
* input3: A 2D array representing the coordinates of each flower.
* input4: A 2D array representing the coordinates of each honeycomb.
* input5: Array containing Source coordinates. 
* input6: Time period.

Output Specification:
---------------------
Your function must return the maximum units of honey collected.

Example 1:
----------
* input1: 2
* input2: 2
* input3: {{3, 3}, {4, 6}}
* input4: {{5, 5}, {6, 1}}
* input5: {1, 4}
* input6: 13

Output: 2

Explanation:
------------
You will first go to the flower at (3, 3) with distance sqrt(5) and then to honeycomb at (5, 5) with distance sqrt(8) and then to flower at (4, 6) and to honeycomb at (5, 5) and back to the house at (1,4) with total distance of sqrt{5} + sqrt{8} + sqrt{2} + sqrt{17} = 12.0160.

Example 2:
----------
* input1: 4
* input2: 1
* input3: {{3, 5}, {7, 5},{7,3}, {8, 4}}
* input4: {{7, 7}}
* input5: {5, 5}
* input6: 22

Output: 3

Explanation:
------------
 "Four flowers and 1 honeycomb present. The maximum flowers the honeybees would be able to travel to would be 3 with a total distance of 19.6251. Hence, the answer is 3."


 */