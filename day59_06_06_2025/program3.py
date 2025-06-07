'''
Write a python program to find the nth prime number. 
The value of n should be input by the user.

Sample Input:
---------------
5

Sample Output:
-----------------
11

'''


n=int(input())
def isPrime(k):
    for i in range(2,k):
        if k%i==0:
            return False
    return True
    
cnt=1
num=2
while cnt!=n:
    num+=1
    value=isPrime(num)
    if value:
        cnt+=1
print(num)