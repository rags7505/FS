'''

Write a program that reads a sentence, count and display the total number of 
vowels and consonants.

Input: 
------
Hello World

Output:
-------
Vowels: 3, Consonants: 7

'''
s=input().lower()
vowels="aeiou"
v,c=0,0
for i in s:
    if i==" ":
        continue
    if i in vowels:
        v+=1
    else:
        c+=1

print("Vowels: ",v,", Consonants: ",c)