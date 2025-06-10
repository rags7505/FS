'''
Write a Python Program to read a sentence and print each word reversed, but 
maintain the original word order.

Input: 
------
Java is fun

Output:
-------
avaJ si nuf

'''
s=input().split(" ")
for i in s:
    print(i[::-1],end=" ")