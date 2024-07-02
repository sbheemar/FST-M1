import pandas

data = {
"Usernames": ["admin", "Sachin", "Charles", "Deku"],
"Password": ["password", "SachPass123", "Charl13", "AllMight"]
}

	
# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)
 
# Write the data to a csv file
dataframe.to_csv("credentials.csv", index=False)

print(dataframe)
