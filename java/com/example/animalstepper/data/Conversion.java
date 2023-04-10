package com.example.animalstepper.data;
public class Conversion {
    //inches to cm
    public static double inches_to_cm(double num) {
        return (double) (num * 2.54);
    }

    //cm to inches
    public static double cm_to_inches(double num) {
        return (double) (num / 2.54);
    }

    public static double ft_height_to_inches(double ft) {
        double num = (double) (12 * ft);
        return num;
    }

    public static double ft_in_height_to_inches(double ft, double inches) {
        double num = (double) (12 * ft) + inches;
        return num;
    }

    //height to stride base on unit and gender
    public static double height_to_stride(double height, String unit, char gender) {
        double inches;
        if (unit.equals("inches")) {
            inches = height;
        } else if (unit.equals("cm")) {
            inches = cm_to_inches(height);
        } else {
            System.out.println("The unit you enter is " + unit + ". Please enter either inches or cm");
            return 0;
        }

        double stride;
        if (gender == 'f') {
            stride = (double) (inches * 0.413);
        } else if (gender == 'm') {
            stride = (double) (inches * 0.415);
        } else {
            System.out.println("Invalid gender. Please enter either f or m");
            return 0;
        }

        return stride;
    }

    public static double meter_to_miles(double num) {
        return (double) (num / 1609.344);
    }

    public static double mile_to_meter(double num) {
        return (double) (num * 1609.344);
    }

    public static double km_to_miles(double num) {
        return (double) (num * 0.621371);
    }

    public static double miles_to_km(double num) {
        return (double) (num / 0.621371);
    }
}