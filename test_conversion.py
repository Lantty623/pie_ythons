import conversion

def test_height_to_stride():
    print("What is the measurement of your height (standard/metrics)?")
    unit = input("measurement: ")
    while(unit != "standard" ) and (unit != "metrics"):
        print("please enter standard or metrics")
        unit = input("measurement: ")

    print("What is your height?")
    if unit == "standard":
        h_ft = int(input("Feet: "))
        h_in = int(input("Inches: "))
        if h_in == 0:
            height = conversion.ft_height_to_inches(h_ft)
        else:
            height = conversion.ft_in_height_to_inches(h_ft,h_in)
    elif unit == "metrics":
        h_cm = float(input("height(cm): "))
        height = conversion.cm_to_inches(h_cm)

    print("What is your gender(f/m): ")
    sex = input()
    stride = round(conversion.height_to_stride(height, "inches", sex))
    print("stride: " + str(stride))

def test_inches_to_cm():
    num = int(input("inches: "))
    cm = conversion.inches_to_cm(num)
    print(cm)

def test_cm_to_inches():
    num = float(input("cm: "))
    inches = conversion.cm_to_inches(num)
    print(inches)

def test_ft_height_to_inches():
    h_ft = int(input("Feet: "))
    height = conversion.ft_height_to_inches(h_ft)
    print(height)

def test_ft_in_height_to_inches():
    h_ft = int(input("Feet: "))
    height = conversion.ft_height_to_inches(h_ft)
    h_in = int(input("Inches: "))
    if h_in == 0:
        height = conversion.ft_height_to_inches(h_ft)
    else:
        height = conversion.ft_in_height_to_inches(h_ft,h_in)
    print(height)


def test_meter_to_miles():
    num = float(input("meter: "))
    num = conversion.meter_to_miles(num)
    print(num)

def test_mile_to_meter():
    num = float(input("miles: "))
    num = conversion.meter_to_miles(num)
    print(num)

def test_km_to_miles():
    num = float(input("km: "))
    num = conversion.km_to_miles(num)
    print(num)

def test_miles_to_km():
    num = float(input("miles: "))
    num = conversion.miles_to_km(num)
    print(num)

def main():
    print("What do you want to test (pick a number):")
    print(" 1. test inches to cm")
    print(" 2. test cm to inches")
    print(" 3. test ft height to inches ")
    print(" 4. test ft in height to inches")
    print(" 5. test height to stride")
    print(" 6. test meter to miles")
    print(" 7. test mile to meter")
    print(" 8. test km to miles")
    print(" 9. test miles to km")
    option = int(input("Option: "))

    match option:
        case 1:
            test_inches_to_cm()
        case 2:
            test_cm_to_inches()
        case 3:
            test_ft_height_to_inches()
        case 4:
            test_ft_in_height_to_inches()
        case 5:
            test_height_to_stride()
        case 6: 
            test_meter_to_miles()
        case 7:
            test_mile_to_meter()
        case 8: 
            test_km_to_miles()
        case 9:
            test_miles_to_km()
        case _:
            print("No matching case")

if __name__ == "__main__":
        main()
