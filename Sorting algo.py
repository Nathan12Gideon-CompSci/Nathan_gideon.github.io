# A sorting algorithm: given a complex data structure, your algorithm should be able to sort the data by a given
# factor. The algorithm should take a data structure and a sorting factor (a string) to sort the data by

def sorting_algrithm(data, key_sort): #standard function procotol
    #we first need to create an empty to copy the orginal list in a way that does not multilate that dictionaray
    Copy_list = []
    for val in data:
        Copy_list.append(val) #sets a separate copy for database

    n = len(Copy_list) # we set n as a sort of benchmark in which allows for the code to repeat no matter the length
    try:
        for y in range(n): #iterates from 0 to n
            for x in range(0,n-y-1): # difficult
                if Copy_list[x][key_sort] > Copy_list[x+1][key_sort]: #checking if value x greater than value x+1 of the same key
                    temp = Copy_list[x] #using temp as a temporay value 
                    Copy_list[x] = Copy_list[x + 1] #copys over
                    Copy_list[x + 1] = temp         #set back
        return print(Copy_list) #until each record is done
    except KeyError:
        print(f"unable to find{key_sort} , try again")
    except Exception as e:
        print("Unknown error")

