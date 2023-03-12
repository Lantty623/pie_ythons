import java.util.Scanner;

public class Test_Conversion {
    public static void test_height_to_stride() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What is the measurement of your height (standard/metrics)?");
            String unit = scanner.nextLine();
            while(!unit.equals("standard") && !unit.equals("metrics")) {
                System.out.println("please enter standard or metrics");
                unit = scanner.nextLine();
            }

            System.out.println("What is your height?");
            double height = 0;
            if (unit.equals("standard")) {
                System.out.print("Feet: ");
                int h_ft = scanner.nextInt();
                System.out.print("Inches: ");
                int h_in = scanner.nextInt();
                if (h_in == 0) {
                    height = Conversion.ft_height_to_inches(h_ft);
                } else {
                    height = Conversion.ft_in_height_to_inches(h_ft, h_in);
                }
            } else if (unit.equals("metrics")) {
                System.out.print("height(cm): ");
                double h_cm = scanner.nextFloat();
                height = Conversion.cm_to_inches(h_cm);
            }

            System.out.println("What is your gender(f/m): ");
            char sex = scanner.next().charAt(0);
            int stride = (int) Math.round(Conversion.height_to_stride(height,"inches", sex));
            System.out.println("stride: " + stride);
        }
    }

    public static void test_inches_to_cm() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("inches: ");
            int num = scanner.nextInt();
            double cm = Conversion.inches_to_cm(num);
            System.out.println(cm);
        }
    }

    public static void test_cm_to_inches() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("cm: ");
            double num = scanner.nextFloat();
            double inches = Conversion.cm_to_inches(num);
            System.out.println(inches);
        }
    }

    public static void test_ft_height_to_inches() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Feet: ");
            int h_ft = input.nextInt();
            double height = Conversion.ft_height_to_inches(h_ft);
            System.out.println(height);
        }
    }

    public static void test_ft_in_height_to_inches() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Feet: ");
            int h_ft = input.nextInt();
            System.out.print("Inches: ");
            int h_in = input.nextInt();
            double height;
            if (h_in == 0) {
                height = Conversion.ft_height_to_inches(h_ft);
            } else {
                height = Conversion.ft_in_height_to_inches(h_ft, h_in);
            }
            System.out.println(height);
        }
    }

    public static void test_meter_to_miles() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("meter: ");
            double num = input.nextFloat();
            num = Conversion.meter_to_miles(num);
            System.out.println(num);
        }
    }
    
    public static void test_mile_to_meter() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("miles: ");
            double num = input.nextFloat();
            num = Conversion.meter_to_miles(num);
            System.out.println(num);
        }
    }
    
    public static void test_km_to_miles() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("km: ");
            double num = input.nextFloat();
            num = Conversion.km_to_miles(num);
            System.out.println(num);
        }
    }
    
    public static void test_miles_to_km() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("miles: ");
            double num = input.nextFloat();
            num = Conversion.miles_to_km(num);
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What do you want to test (pick a number):");
            System.out.println(" 1. test inches to cm");
            System.out.println(" 2. test cm to inches");
            System.out.println(" 3. test ft height to inches ");
            System.out.println(" 4. test ft in height to inches");
            System.out.println(" 5. test height to stride");
            System.out.println(" 6. test meter to miles");
            System.out.println(" 7. test mile to meter");
            System.out.println(" 8. test km to miles");
            System.out.println(" 9. test miles to km");
            System.out.print("Option: ");
            int option = input.nextInt();
                
            switch (option) {
                case 1:
                    test_inches_to_cm();
                    break;
                case 2:
                    test_cm_to_inches();
                    break;
                case 3:
                    test_ft_height_to_inches();
                    break;
                case 4:
                    test_ft_in_height_to_inches();
                    break;
                case 5:
                    test_height_to_stride();
                    break;
                case 6:
                    test_meter_to_miles();
                    break;
                case 7:
                    test_mile_to_meter();
                    break;
                case 8:
                    test_km_to_miles();
                    break;
                case 9:
                    test_miles_to_km();
                    break;
                default:
                    System.out.println("No matching case");
                }
        }
    }
}
