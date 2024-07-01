from selenium import webdriver
from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.common.by import By
import time

with webdriver.Firefox() as driver:
    #Open URL
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Page Opened: ", driver.title)

    username = driver.find_element(By.ID, "username").send_keys("admin")
    print("Username Entered")

    password = driver.find_element(By.ID, "password").send_keys("password")
    print("Password Entered")

    login = driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div/button").click()
    time.sleep(5)
    print("Login Successful")
