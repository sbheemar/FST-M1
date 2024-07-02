from selenium import webdriver
from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.common.by import By
import time

with webdriver.Firefox() as driver:
    #Open URL
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Page Opened: ", driver.title)

    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")

    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    time.sleep(2)
    driver.find_element(By.XPATH, "//button[@type='submit']").click()
    time.sleep(2)

    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    print("Login message: ", message.text)
