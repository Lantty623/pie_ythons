from conversion import *

dog_chart = {
    #dog bread : inches,cm
    "Golden Retriever" : [3.75, 9.5],
    "Yorkshire Terrier" : [1.5, 3.8],
    "Bulldog": [1.77, 4.5],
    "Samoyed": [2.55],
    "Shiba Inu": [3.75, 9.5],
    "Toy Poodle": [1.5, 3.8],
    "Chihuahua": [1.5, 3.8],
    "German Shepherd": [4.25, 10.8],
    "Great Dane": [5.25, 14]
}

dog_breed_paw_chart = {
    #breed_size : inches, cm
    "XXLARGE" : [5.5, 14],
    "XLARGE" : [4.75, 12.1],
    "LARGE" : [4.25, 10.8],
    "MEDIUM" : [3.75, 9.5],
    "SMALL" : [3.25, 8.25],
    "XSMALL" : [2.75, 7],
    "XXSMAL" : [2.25, 5.2],
    "ITTY BITTY" : [1.5, 3.8]
}


#House cat - 2 inches step
#human = inputting human_step
#unit = the unit that the human_step is in (inches/cm)
def human_to_house_cat(human, unit):
    cat_step = 0
    if(unit == "inches"):
        cat_step = float(human/2)
    elif (unit == "cm"):
        step = cm_to_inches(human)
        cat_step = float(step/2)
    else: 
        print("Give me an inches/cm. Not " + str(unit))
    
    return cat_step

def human_to_dog(human, unit):
    dog_step = 0
    print("What dog you want (Enter a number):")
    print("1. Golden Retriever" )
    print("2. Yorkshire Terrier" )
    print("3. Bulldog" )
    print("4. Samoyed" )
    print("5. Shiba Inu" )
    print("6. Toy Poodle" )
    print("7. Chihuahua" )
    print("8. German Shepherd" )
    print("9. Great Dane" )
    option = int(input("Option: "))
    
    if unit == "inches":
        index = 0
    elif unit == "cm":
        index = 1

    match option:
        case 1:
            dog_step = float(human/dog_chart["Golden Retriever"][index])
        case 2:
            dog_step = float(human/dog_chart["Yorkshire Terrier"][index])
        case 3:
            dog_step = float(human/dog_chart["Bulldog"][index])
        case 4:
            dog_step = float(human/dog_chart["Samoyed"][index])
        case 5:
            dog_step = float(human/dog_chart["Shiba Inu"][index])
        case 6:
            dog_step = float(human/dog_chart["Toy Poodle"][index])
        case 7:
            dog_step = float(human/dog_chart["Chihuahua"][index])
        case 8:
            dog_step = float(human/dog_chart["German Shepherd"][index])
        case 9:
            dog_step = float(human/dog_chart["Great Dane"][index])
        case _:
            print("No matching case")
    return dog_step
