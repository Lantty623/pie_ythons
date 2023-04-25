from animal import *

def test_house_cat():
    option = int(input("1. inches\n2. cm\n"))
    if option == 1:
        unit = "inches"
    elif option == 2:
        unit = "cm"
    num = int(input("Measurement: "))
    cat_step = round(human_to_house_cat(num,unit), 2)
    print("cat step: "+ str(cat_step))

def test_dog():
    option = int(input("1. inches\n2. cm\n"))
    if option == 1:
        unit = "inches"
    elif option == 2:
        unit = "cm"
    num = int(input("Measurement: "))
    dog_step = round(human_to_dog(num,unit), 2)
    print("dog step: " + str(dog_step))


def main():
    print("What do you want to test (pick a number):")
    print(" 1. house cat ")
    print(" 2. dog")
    print(" 3. ")
    print(" 4. ")
    option = int(input("Option: "))

    match option:
        case 1:
            test_house_cat()
        case 2:
            test_dog()
        case 3:
            pass
        case 4:
            pass
        case _:
            print("No matching case")

if __name__ == "__main__":
        main()