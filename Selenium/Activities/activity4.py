from selenium import webdriver
from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.common.by import By
import time

with webdriver.Firefox() as driver:
    #Open URL
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Page Opened: ", driver.title)

    third_heading = driver.find_element(By.XPATH, "//h3[@id='third-header']")
    print("Header text: ", third_heading.text)

    fifth_heading = driver.find_element(By.XPATH, "//h5[@class='ui green header']")
    print("Header color: ", fifth_heading.value_of_css_property("color"))

    violet_button = driver.find_element(By.XPATH, "//button[@class='ui violet button']")
    print("Violet Button class: ", violet_button.get_attribute("class"))

    grey_button = driver.find_element(By.CLASS_NAME, "grey")
    print("Grey button's text is: ", grey_button.text)



                        