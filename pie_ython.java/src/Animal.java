import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Animal {
    //From website: https://www.verywellfit.com/set-pedometer-better-accuracy-3432895
    //We agree to use the average 5 6" stide length = 27
    static double STRIDE_INCHES = 27;
    static double STRIDE_CM = 68.58;
    //CAT in cm
    static double CAT = 36;
    //Elephant in cm
    static double ELEPHANT = 200;
    //Horse in Inches
    static double HORSE = 144;
    //Dog in cm 
    static double LDOG = 35;
    static double MDOG = 25;
    static double SDOG = 15;
    //kangaroo's stride is about 6 meter = 600 cm
    static double KANGAROO = 600;

    static Map<String, double[]> dog_chart = new HashMap<String, double[]>() {{
        put("Golden Retriever", new double[] {3.75, 9.5});
        put("Yorkshire Terrier", new double[] {1.5, 3.8});
        put("Bulldog", new double[] {1.77, 4.5});
        put("Samoyed", new double[] {2.55});
        put("Shiba Inu", new double[] {3.75, 9.5});
        put("Toy Poodle", new double[] {1.5, 3.8});
        put("Chihuahua", new double[] {1.5, 3.8});
        put("German Shepherd", new double[] {4.25, 10.8});
        put("Great Dane", new double[] {5.25, 14});
    }};

    static Map<String, double[]> dog_breed_paw_chart = new HashMap<String, double[]>() {{
        put("XXLARGE", new double[] {5.5, 14});
        put("XLARGE", new double[] {4.75, 12.1});
        put("LARGE", new double[] {4.25, 10.8});
        put("MEDIUM", new double[] {3.75, 9.5});
        put("SMALL", new double[] {3.25, 8.25});
        put("XSMALL", new double[] {2.75, 7});
        put("XXSMAL", new double[] {2.25, 5.2});
        put("ITTY BITTY", new double[] {1.5, 3.8});
    }};

    //int human = the number of step
    public static double human_to_cat(int human, String unit) {
        double cat_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            cat_step = len / CAT;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            cat_step = len / CAT;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        return (int)(Math.round(cat_step));
    }

    public static double human_to_elephant(int human, String unit) {
        double ele_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            ele_step = len / ELEPHANT;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            ele_step = len / ELEPHANT;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (ele_step < 1){
            return ele_step;
        }else{
            return (int)(Math.round(ele_step));
        }
    }
    //int human = the number of step
    public static double human_to_horse(int human, String unit) {
        double h_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            len = human * STRIDE_INCHES;
            h_step = len / HORSE;
        } else if (unit.equals("cm")) {
            double length = (human * STRIDE_CM);
            len = Conversion.cm_to_inches(length);
            h_step = len / HORSE;
        } else {
           System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (h_step < 1){
            return h_step;
        }else{
            return (int)(Math.round(h_step));
        }
    }

    //int human = the number of step
    public static double human_to_ldog(int human, String unit) {
        double d_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            d_step = len / LDOG;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            d_step = len / LDOG;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (d_step < 1){
            return d_step;
        }else{
            return (int)(Math.round(d_step));
        }
    }

    public static double human_to_mdog(int human, String unit) {
        double d_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            d_step = len / MDOG;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            d_step = len / MDOG;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (d_step < 1){
            return d_step;
        }else{
            return (int)(Math.round(d_step));
        }
    }

    public static double human_to_sdog(int human, String unit) {
        double d_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            d_step = len / SDOG;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            d_step = len / SDOG;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (d_step < 1){
            return d_step;
        }else{
            return (int)(Math.round(d_step));
        }
    }

    public static double human_to_kangaroo(int human, String unit) {
        double k_step = 0;
        double len = 0;
        if (unit.equals("inches")) {
            double length = (human * STRIDE_INCHES);
            len = Conversion.inches_to_cm(length);
            k_step = len / KANGAROO;
        } else if (unit.equals("cm")) {
            len = human * STRIDE_CM;
            k_step = len / KANGAROO;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        if (k_step < 1){
            return k_step;
        }else{
            return (int)(Math.round(k_step));
        }
    }

    
    public static double human_to_dog_paw(double human, String unit) {
        double dog_step = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What dog you want (Enter a number):");
            System.out.println("1. Golden Retriever");
            System.out.println("2. Yorkshire Terrier");
            System.out.println("3. Bulldog");
            System.out.println("4. Samoyed");
            System.out.println("5. Shiba Inu");
            System.out.println("6. Toy Poodle");
            System.out.println("7. Chihuahua");
            System.out.println("8. German Shepherd");
            System.out.println("9. Great Dane");
            int option = scanner.nextInt();
            int index = 0;
            double len = STRIDE_INCHES;
            if (unit.equals("cm")) {
                index = 1;
                len = STRIDE_CM;
            }
   
            switch (option) {
                case 1:
                    dog_step = (len*human) / dog_chart.get("Golden Retriever")[index];
                    break;
                case 2:
                    dog_step = (len*human) / dog_chart.get("Yorkshire Terrier")[index];
                    break;
                case 3:
                    dog_step = (len*human) / dog_chart.get("Bulldog")[index];
                    break;
                case 4:
                    dog_step = (len*human) / dog_chart.get("Samoyed")[index];
                    break;
                case 5:
                    dog_step = (len*human) / dog_chart.get("Shiba Inu")[index];
                    break;
                case 6:
                    dog_step = (len*human) / dog_chart.get("Toy Poodle")[index];
                    break;
                case 7:
                    dog_step = (len*human) / dog_chart.get("Chihuahua")[index];
                    break;
                case 8:
                    dog_step = (len*human) / dog_chart.get("German Shepherd")[index];
                    break;
                case 9:
                    dog_step = (len*human) / dog_chart.get("Great Dane")[index];
                    break;
                default:
                    System.out.println("No matching case");
                    break;
            }
        }
        return (int)(Math.round(dog_step));
    }

}
