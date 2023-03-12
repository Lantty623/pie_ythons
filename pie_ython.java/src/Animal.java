import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Animal {
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

    public static double human_to_house_cat(double human, String unit) {
        double cat_step = 0;
        if (unit.equals("inches")) {
            cat_step = human / 2.0;
        } else if (unit.equals("cm")) {
            double step = Conversion.cm_to_inches(human);
            cat_step = step / 2.0;
        } else {
            System.out.println("Give me an inches/cm. Not " + unit);
        }
        return cat_step;
    }
    
    public static double human_to_dog(double human, String unit) {
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
            if (unit.equals("cm")) {
                index = 1;
            }
   
            switch (option) {
                case 1:
                    dog_step = human / dog_chart.get("Golden Retriever")[index];
                    break;
                case 2:
                    dog_step = human / dog_chart.get("Yorkshire Terrier")[index];
                    break;
                case 3:
                    dog_step = human / dog_chart.get("Bulldog")[index];
                    break;
                case 4:
                    dog_step = human / dog_chart.get("Samoyed")[index];
                    break;
                case 5:
                    dog_step = human / dog_chart.get("Shiba Inu")[index];
                    break;
                case 6:
                    dog_step = human / dog_chart.get("Toy Poodle")[index];
                    break;
                case 7:
                    dog_step = human / dog_chart.get("Chihuahua")[index];
                    break;
                case 8:
                    dog_step = human / dog_chart.get("German Shepherd")[index];
                    break;
                case 9:
                    dog_step = human / dog_chart.get("Great Dane")[index];
                    break;
                default:
                    System.out.println("No matching case");
                    break;
            }
        }
        return dog_step;
    }

}
