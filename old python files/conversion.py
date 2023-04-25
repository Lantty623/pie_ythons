
#inches to  cm
def inches_to_cm(num):
    return float(num*2.54)

#cm to inches
def cm_to_inches(num):
        return float(num/2.54)

def ft_height_to_inches(ft):
    num = float(12*ft)
    return num

def ft_in_height_to_inches(ft,inches):
    num = float(12*ft)+inches
    return num

#height to stride base on unit and gender
def height_to_stride(height,unit,gender):
    if unit == "inches":
        #print(height)
        inches = height
    elif unit == "cm":
        inches = cm_to_inches(height)
    else:
        print("The unit you enter is " + str(unit) + " . Please enter either inches or cm")

    if gender == "f":
        stride = float(inches * 0.413)
    if gender == "m":
        stride = float(inches * 0.415)

    return stride
    
def meter_to_miles(num):
    return float(num/1609.344)

def mile_to_meter(num):
    return float(num*1609.344)

def km_to_miles(num):
    return float(num*0.621371)

def miles_to_km(num):
    return float(num/0.621371)