'''

Write a python program, for given a birthdate in yyyy-MM-dd format, calculate 
the person’s current age in years, months, and days.

Input:
------
1990-05-25

Output:
-------
Age: 34 years, 0 months, 10 days

'''
from datetime import datetime, date
from dateutil.relativedelta import relativedelta

# Read birthdate input
birth_input = input().strip()

# Convert string to date object
birth_date = datetime.strptime(birth_input, "%Y-%m-%d").date()
today = date.today()

# Calculate the difference using relativedelta
age = relativedelta(today, birth_date)

# Display the result
print(f"Age: {age.years} years, {age.months} months, {age.days} days")