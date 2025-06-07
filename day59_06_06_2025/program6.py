'''

Write a Python code to return the length of longest sub-string without repeating 
characters

Sample Input: 
-------------
abcabcbb

Sample Output: 
--------------
3

'''

s=input()
l=0
d={}
ans=0
for j in range(0,len(s)):
    if s[j] in d:
        d[s[j]]+=1
    else:
        d[s[j]]=1
    while d[s[j]]>1:
        d[s[l]]-=1
        l+=1
    ans=max(ans,j-l+1)
print(ans)