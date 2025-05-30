import os
import time
import pdfkit
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager

start_roll = 245522733130
end_roll = 245522733193

# Set path to wkhtmltopdf if needed
path_to_wkhtmltopdf = r'C:\Program Files\wkhtmltopdf\bin\wkhtmltopdf.exe'
config = pdfkit.configuration(wkhtmltopdf=path_to_wkhtmltopdf)

# Selenium setup
options = Options()
options.add_argument('--headless')
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

url = "https://www.osmania.ac.in/res07/20250403.jsp"
html_output = """
<html><head><meta charset="utf-8">
<style>
body { font-family: Arial, sans-serif; font-size: 14px; margin: 30px; }
.page-break { page-break-after: always; }
table, td, th { border: 1px solid black; border-collapse: collapse; padding: 6px; }
</style>
</head><body>
<h1>Osmania University Results</h1>
"""

def result_loaded(page_source):
    return "subject" in page_source.lower() or "marks" in page_source.lower()

for roll in range(start_roll, end_roll + 1):
    print(f"Fetching result for {roll}...")
    driver.get(url)
    time.sleep(2)

    try:
        input_box = driver.find_element(By.NAME, "htno")
        input_box.clear()
        input_box.send_keys(str(roll))
        input_box.submit()
        time.sleep(3)

        if result_loaded(driver.page_source):
            soup = BeautifulSoup(driver.page_source, 'html.parser')
            table = soup.find("table")
            if table:
                html_output += f"<div><h2>Roll Number: {roll}</h2>{str(table)}</div><div class='page-break'></div>"
                print(f"✅ Added result for {roll}")
            else:
                html_output += f"<div><h2>Roll Number: {roll}</h2><p>No table found.</p></div><div class='page-break'></div>"
                print(f"⚠️ No result table for {roll}")
        else:
            html_output += f"<div><h2>Roll Number: {roll}</h2><p>No result found or error loading.</p></div><div class='page-break'></div>"
            print(f"❌ No result loaded for {roll}")

    except Exception as e:
        html_output += f"<div><h2>Roll Number: {roll}</h2><p>Error: {str(e)}</p></div><div class='page-break'></div>"
        print(f"❌ Error for {roll}: {e}")

driver.quit()
html_output += "</body></html>"

# Save HTML file
with open("ou_results.html", "w", encoding="utf-8") as f:
    f.write(html_output)

# Convert to PDF
pdfkit.from_file("ou_results.html", "Osmania_Results_Final.pdf", configuration=config)
print("🎉 Final PDF saved as Osmania_Results_Final.pdf")
