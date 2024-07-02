import pytest


def test_addition():
	
    # Enter two numbers
	num1 = 10
	num2 = 15
    
	# Add both num1 and num2
	sum = num1 + num2

	# Assertion
	assert sum == 25

# Subtraction test
def test_subtraction():
  
	# Enter two numbers
	num1 = 50
	num2 = 35
    
	# Subtract both num1 and num2
	diff = num1 - num2

	# Assertion
	assert diff == 15

# Multiplication test
def test_multiplication():
  
	# Enter two numbers
	num1 = 5
	num2 = 20
    
	# Multiply both num1 and num2
	prod = num1 * num2

	# Assertion
	assert prod == 100

# Division test
def test_division():
  
	# Enter two numbers
	num1 = 100
	num2 = 5
    
	# Divide num1 by num2
	quot = num1 / num2

	# Assertion
	assert quot == 20