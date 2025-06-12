package Other_codes_Drives.copart_programs;
/*
 Question: 13

Question 4: No Fight Please!

Problem Statement:

Mr. Cumberbatch is the Godfather of the town. People of different gangs have started fighting each other. Being the Godfather, he wants to keep the violence to a minimum. Since everyone respects him, the gangs stop fighting.

Now, he has to move people from that place to somewhere else.He knows the total number of people i.e X.He has a vehicle in which Y people can sit at a time.

He has made a hate mantrix which has N pairs (m,n),(1<=m,=x and 1<=n<=X) each pair means that perso m hates n, and they can travel together but will start fighting if they are left together at one place.Mr Cumberbatch has to find out the many minimum number of trips his vehicle will have to make to transport all the people without any fights.

Input Specification:
--------------------
* input1: X → Total number of people
* input2: N → Number of pairs in the hate matrix
* input3: Y → Number of people that can sit in the vehicle at a time
* input4: hate matrix  Consisting N pairs 

Output Specification:
----------------------
* Your function should return the number of trips the vehicle has to make.

Example 1:
----------
input1: 3  
input2: 2  
input3: 1  
input4: {(1,2), (2,3)}

Output:
7

Explanation:
------------
* Trip 1: person 2 to safe place
* Trip 2: vehicle back with no person
* Trip 3: person 1 to the safe place
* Trip 4: person 2 back to the original place
* Trip 5: person 3 to the safe place
* Trip 6: vehicle back with no person
* Trip 7: person 2 to the safe place



Example 2:
----------
input1: 3  
input2: 3  
input3: 2  
input4: {(1,2), (1,3), (2,3)}


Output:
3


Explanation:
------------
The trips taken will be
* Trip 1: person 1 and 2 to safe place
* Trip 2: Back with person 2 
* Trip 3: person 2 and 3 to safe place

 */