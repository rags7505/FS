'''
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

'''

str=input().split(" ")
d={}
l=[]
index=0
for s in str:
    if s in d:
        d[s]+=1
    else:
        d[s]=1
        l.append(index)
    index+=len(s)+1
index=0
for i in d:
    print(i," -> first index: ",l[index]," count: ",d[i])
    index+=1

