name = input("Please enter your name: ")
age = int(input("How old are you: "))
year = str ((2024-age)+100)
if age < 18:
    print ("You are still a minor") 
else:
    print ("You are an adult")
print (name + " will be 100 years old in the year" + year)

