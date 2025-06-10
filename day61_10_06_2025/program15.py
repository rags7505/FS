'''

Write a python program that reads two timestamps (yyyy-MM-dd HH:mm:ss format) and
display the time elapsed between them in minutes and seconds.

Input: 
------
2025-06-04 10:30:00
2025-06-04 11:15:40

Output: 
-------
Elapsed: 45 minutes 40 seconds

'''

from datetime import datetime

# Read input timestamps
t1 = input().strip()
t2 = input().strip()

# Parse timestamps into datetime objects
fmt = "%Y-%m-%d %H:%M:%S"
dt1 = datetime.strptime(t1, fmt)
dt2 = datetime.strptime(t2, fmt)

# Calculate the time difference
elapsed = abs(dt2 - dt1)  # ensures positive timedelta

# Extract minutes and seconds
total_seconds = int(elapsed.total_seconds())
minutes = total_seconds // 60
seconds = total_seconds % 60

# Display result
print(f"Elapsed: {minutes} minutes {seconds} seconds")

'''

from datetime import datetime

t1 = input()
t2 = input()

dt1 = datetime.strptime(t1, "%Y-%m-%d %H:%M:%S")
dt2 = datetime.strptime(t2, "%Y-%m-%d %H:%M:%S")

diff = dt2 - dt1

print(f"Elapsed: {diff.seconds // 60} minutes {diff.seconds % 60} seconds")
'''