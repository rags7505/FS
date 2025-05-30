from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from time import sleep
from PIL import Image
from fpdf import FPDF
import os

start_roll = 245522733130
end_roll = 245522733193

options = Options()
options.add_argument('--headless')
options.add_argument('--window-size=1200x2000')  # Big enough to capture result page

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

url = "https://www.osmania.ac.in/res07/20250403.jsp"
output_dir = "screenshots"
os.makedirs(output_dir, exist_ok=True)

images = []

for roll in range(start_roll, end_roll + 1):
    driver.get(url)
    sleep(1)

    try:
        # Fill in the hall ticket number
        input_box = driver.find_element(By.NAME, "htno")
        input_box.clear()
        input_box.send_keys(str(roll))

        # Submit the form
        input_box.submit()
        sleep(2)

        # Screenshot the result page
        filename = f"{output_dir}/{roll}.png"
        driver.save_screenshot(filename)
        images.append(filename)
        print(f"Saved result for {roll}")

    except Exception as e:
        print(f"Error for roll {roll}: {e}")

driver.quit()

# Combine screenshots into a single PDF
pdf = FPDF()
for image in images:
    cover = Image.open(image)
    width, height = cover.size
    pdf_w, pdf_h = 210, 297  # A4 size in mm
    aspect = height / width
    pdf_h = pdf_w * aspect
    pdf.add_page()
    pdf.image(image, 0, 0, pdf_w, pdf_h)

pdf.output("All_OU_Results.pdf", "F")
print("✅ Final PDF saved as All_OU_Results.pdf")
