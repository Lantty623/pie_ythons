import java.util.Scanner;

public class Test_Animal{
    
    public static void test_house_cat() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What measurement you want it in:\n1. inches\n2. cm");
            int option = scanner.nextInt();
            String unit = "";
            if (option == 1) {
                unit = "inches";
            } else if (option == 2) {
                unit = "cm";
            }
            System.out.print("Human Step: ");
            int num = scanner.nextInt();
            int catStep = (int)Animal.human_to_house_cat(num, unit);
            System.out.println("cat step: " + catStep);
        }
    }
    
    public static void test_dog() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1. inches\n2. cm");
            int option = scanner.nextInt();
            String unit = "";
            if (option == 1) {
                unit = "inches";
            } else if (option == 2) {
                unit = "cm";
            }
            System.out.print("Measurement: ");
            int num = scanner.nextInt();
            int dogStep = (int)Animal.human_to_dog(num, unit);
            System.out.println("dog step: " + dogStep);
        }
    }
    public static void test_elephant() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What measurement you want it in:\n1. inches\n2. cm");
            int option = scanner.nextInt();
            String unit = "";
            if (option == 1) {
                unit = "inches";
            } else if (option == 2) {
                unit = "cm";
            }
            System.out.print("Human Step: ");
            int num = scanner.nextInt();

            double eleStep = Animal.human_to_elephant(num, unit);
            if (eleStep < 1){
                System.out.println("Elephant step: " + String.format("%.2f", eleStep));
            }else{
                int step = (int)eleStep;
                System.out.println("Elephant step: " + step);
            }
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What do you want to test (pick a number):");
            System.out.println(" 1. house cat ");
            System.out.println(" 2. dog");
            System.out.println(" 3. elephant");
            System.out.println(" 4. ");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    test_house_cat();
                    break;
                case 2:
                    test_dog();
                    break;
                case 3:
                    test_elephant();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("No matching case");
                    break;
            }
        }
    }
}
