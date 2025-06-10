'''

Write a python program that reads a sentence and counts how many times each word 
appears. Display only the words that occur more than once.

Input: 
------
this is a test this test is easy

Output:
-------
this -> 2
is -> 2
test -> 2

'''
s=input().split(" ")
d={}
for i in s:
    if i in d:
        d[i]+=1
    else:
        d[i]=1
for i in d:
    if d[i]>1:
        print(i,"->",d[i])