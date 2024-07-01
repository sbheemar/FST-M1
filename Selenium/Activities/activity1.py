from selenium import webdriver
from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    #Open URL
    driver.get("https://v1.training-support.net/")
    print(driver.title)

    #Print Page Title
    print("Page Title: ", driver.title)

    #Find About Us button and Click
    driver.find_element(By.ID, "about-link").click()

    print("About Us Page title: ", driver.title)




