import pandas


dataframe = pandas.read_csv('credentials.csv')




print("-----------------------------------")
print("Complete Data: ")
print(dataframe)

print("-----------------------------------")
print("Usernames:")
print(dataframe["Usernames"])

print("-----------------------------------")
print(dataframe["Usernames"])
print("Username: ", dataframe["Usernames"][1], "Password: ", dataframe["Password"][1])

print("-----------------------------------")
print("Usernames sorted by ascending order")
print(dataframe.sort_values("Usernames"))

print("-----------------------------------")
print("Password sorted by descending order")
print(dataframe.sort_values("Password", ascending=False))