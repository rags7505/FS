'''
A Train  has to go through N railway-stations, the stations are in a cyclic route. 
Each railway-station 'k' has coal[k].

The Train has unlimited coal tank and it consumes cost[i] of coal to travel 
from railway-station i to its next railway-station (i+1). 

The Train starts with an empty coal tank at one of the railway-stations.

Return the starting railway station's index,
If you can travel through all the railway-stations and 
reaches the starting-station in the clockwise direction, 
otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.

Input Format:
-------------
Line-1 -> Space separated integers coal[i]. 
Line-2 -> Space separated integers cost[i].

Output Format:
--------------
Print the station number if possible,
Otherwise print -1.


Sample Input-1:
---------------
1 2 3 4 5
3 4 5 1 2

Sample Output-1:
----------------
3

Explanation:
------------
Start at station 3 (index 3) and fill up with 4 unit of coal.
Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. The coal is just enough to travel back to
station 3.Therefore, return 3 as the starting index.

Sample Input-1:
---------------
2 3 4
3 4 3

Sample Output-1:
----------------
-1

Explanation:
------------
You can't start at station 0 or 1, as there is not enough coal to travel to the 
next station.
Let's start at station 2 and fill up with 4 unit of coal. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of coal but you only
have 3.
Therefore, you can't travel around all the stations and reach the starting 
staton once no matter where you start

'''

# simmu code

coal = [int(x) for x in input().split()]
cost = [int(x) for x in input().split()]

def helper():
    total, curr, start, n = 0, 0, 0, len(coal)
    for i in range(len(coal)):
        total += coal[i] - cost[i]
        curr += coal[i] - cost[i]
        
        if curr < 0:
            start = i + 1
            curr = 0
            
    return start if total >= 0 and start < n else -1

print(helper())

