def maxPoints(elements):
    score = 0
    array = []  
    elements.sort()  
    while len(elements) > 0:
        max = elements[len(elements)-1]
        for j in elements:
            if j == max or j == max - 1:
                if j == max:
                    score = score + j
            else:
                array.append(j)
        elements = array
        array = []       
    
    return score

elements = [3,3,4,2]


print(maxPoints(elements))