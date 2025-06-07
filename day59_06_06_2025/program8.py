'''

Problem: 
Write Python code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

'''
s=input().split(" ")
s1,s2=s[0],s[1]
f=[0]*26
for c in s1:
    f[ord(c)-ord('a')]+=1
for c in s2:
    f[ord(c)-ord('a')]-=1
flag=0
for i in f:
    if i!=0:
        flag=1
        break
if flag==0:
    print("true")
else:
    print("false")