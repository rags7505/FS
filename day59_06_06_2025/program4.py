'''

Write a python program to convert a decimal number to binary using both
1. Recursive method
2. Iterative method

Implement the methods in Solution class and return the binary number.

Sample Input:
---------------
10

Sample Output:
------------------
Binary (Recursive): 1010
Binary (Iterative): 1010
'''

def iterative(n):
    s=""
    while n!=0:
        rem=str(n%2)
        n=n//2
        s=rem+s
    return s
    
    
def recursive(n):
    if n==0:
        return ""
    s=""
    s=recursive(n//2)+str(n%2)
    return s
    
    
n=int(input())
print("Binary (Recursive): ",iterative(n))
print("Binary (Iterative): ",recursive(n))