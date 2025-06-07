'''
Problem: 
--------
Write a Python code to identify the nth largest number without 
sorting the array


Sample Input:
-------------
4 2
3 1 5 2

Sample Output:
--------------
3

'''

def find(n, arr):
    temp = arr[:]
    for _ in range(n-1):
        max1 = float('-inf')
        for num in temp:
            if num > max1:
                max1 = num
        temp.remove(max1)
    largest = float('-inf')
    for num in temp:
        if num > largest:
            largest = num
    return largest


size, n = map(int, input().split())
arr = list(map(int, input().split()))

print(find(n,arr))