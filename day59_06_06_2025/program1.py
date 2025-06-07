'''
Write a python program to read a comma-separated values file and print its 
contents in table format, replacing commas with tabs or spaces.

Input File: 
------
file.csv

Output:
-------
name age
John 20
Jane 25

Explanation:
-------------
File contains:- 

name,age
John,20
Jane,25

'''

file = input()

try:
    with open(file, 'r') as f:
        for line in f:
            line = line.strip().replace(",", "\t")
            print(line)
except IOError as e:
    print(e)

