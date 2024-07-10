from selenium import webdriver
from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    actions = webdriver.ActionChains(driver)

    #Open Training Support
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Page Opened: ", driver.title)

    actions.click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after left click: ", active_side.text)
    
    # Perform a DOUBLE CLICK action
    actions.double_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after double click: ", active_side.text)

    # Perform a RIGHT CLICK action
    actions.context_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after right click: ", active_side.text)