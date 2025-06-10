'''

Write a program that finds the longest substring that reads the same forwards 
and backwards.

Input: 
------
babad

Output: 
-------
bab or aba

'''
s=input()
max=""
for i in range(len(s)):
    for j in range(i+1,len(s)+1):
        substr=s[i:j]
        if substr==substr[::-1] and len(max)<len(substr):
            max=substr
            
print(max)