#A filtering algorithm: 
# given a complex data structure, your algorithm must be able to filter by some factor of the data (e.g., if the data structure is a list of students, where students have several factors, your algorithm
# should be able to return only students meeting a certain requirement, like gender or home country). 
# The algorithm should take a data structure, a filtering key (a string corresponding to a key in an internal dictionary) to filter the data on and a filtering value to indicate the data to retain.

def Flitering_algo(dict, filter_key, filter_val): #standard fuction definition  
    fil_list = []
    try:
        for record in dict: #uses interation 
            if record.get(filter_key) == filter_val: #simple enough
                fil_list.append(record) #remember the basics
            return fil_list
        print(fil_list)
    except KeyError:
        print("Key was invaild, try again")
    except Exception:
        print("Unknown error")

dat = [{ "name": "James", "class": "FC01", "exam score": 75, "coursework score": 45 },
{ "name": "Natasha", "class": "FC02", "exam score": 95, "coursework score": 85 },
{ "name": "Kumail", "class": "FC02", "exam score": 85, "coursework score": 75 },
{ "name": "Tariq", "class": "FC01", "exam score": 75, "coursework score": 55 },
{ "name": "Qimeng", "class": "FC01", "exam score": 80, "coursework score": 80 },
{ "name": "Ming", "class": "FC02", "exam score": 90, "coursework score": 75 }]

Flitering_algo(dat, "coursework score", 75)