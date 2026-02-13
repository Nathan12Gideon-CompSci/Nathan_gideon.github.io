# An aggregating algorithm: 
# given a complex data structure, 
# you must write an algorithm to aggregate by a given factor, 
# usually providing a mean (e.g., if the data is a list of students, 
# the algorithm should be able to group students by nationality and give an average age for each group). 
# The algorithm should take a data structure and an aggregation key (a string corresponding to a key in an internal dictionary) to aggregate the data by

def aggerate(dict, keygroup, value_key):
    sums = {} #so just sums
    counts = {} #keeps count
    try:
        for rec in dict:
            cate = rec.get(keygroup) #takes the group it belongs to, for output and checking
            val = rec.get(value_key) # the value
            if cate not in sums: #not in means "is it in" if it is, it just just skips it. 
                sums[cate] = 0.0 #the keygroup isn't in, just turn the thing into a key and its value 0, same for next line
                counts[cate] = 0 #since we dont count it 
            sums[cate] += val
            counts[cate] += 1
        
        average = {} #just basic maths
        for cate in sums:
            average[cate] = sums[cate] / counts[cate]
        return print(average)
    except KeyError:
        print("Key was not found, try again")
    except Exception:
        print("unknown error")





