#Sum of all numbers entered by the user

numbers = list (input("Enter the list of numbers with comma separated values:").split(", "))
sum = 0

for number in numbers:
    sum += int(number)

print(sum)
