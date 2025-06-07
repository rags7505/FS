'''

Write Java code to print system date & time in format like 
2021-10-02 10:30:00 AM

Sample Output: 2025-06-04 11:35:27 AM

'''
from datetime import datetime

now = datetime.now()
formatted = now.strftime("%Y-%m-%d %I:%M:%S %p")
print(formatted)