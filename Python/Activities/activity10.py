instring = input("Enter some numbers separated by spaces: ") 

out_tuple = tuple((int(x) for x in instring.split())) 

print("Given list is ", out_tuple)
 
# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in out_tuple:
    if (num % 5 == 0):
        print(num)