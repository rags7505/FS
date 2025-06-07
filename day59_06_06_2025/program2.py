'''

Write python code for a method which takes a String (a sentence) as input 
and returns a Map. The Map key is String (word in the String) and 
value is frequency of the word in the given sentence.
(In the words ignore any special characters)

Sample Input:
-------------
Java is fun, and Ja#va@ is powerful 

Sample Output:
--------------
java: 2
is: 2
fun: 1
and: 1
powerful: 1

'''

str=input().lower().split(" ")
d={}
for i in str:
    s=""
    for char in i:
        if char>='a' and char<='z':
            s+=char
    if s in d:
        d[s]=d[s]+1
    else:
        d[s]=1
print(d)