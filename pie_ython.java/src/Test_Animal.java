import java.util.Scanner;

public class Test_Animal{
    
    public static void test_cat() {
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
            int catStep = (int)Animal.human_to_cat(num, unit);
            System.out.println("cat step: " + catStep);
        }
    }
    
    public static void test_dog_paw() {
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
            int dogStep = (int)Animal.human_to_dog_paw(num, unit);
            System.out.println("dog paw: " + dogStep);
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

    public static void test_horse() {
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

            double hStep = Animal.human_to_horse(num, unit);
            if (hStep < 1){
                System.out.println("Horse step: " + String.format("%.2f", hStep));
            }else{
                int step = (int)hStep;
                System.out.println("Horse step: " + step);
            }
        }
    }

    public static void test_ldog() {
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
            double dStep = Animal.human_to_ldog(num, unit);
            if (dStep < 1){
                System.out.println("Large Dog step: " + String.format("%.2f", dStep));
            }else{
                int step = (int)dStep;
                System.out.println("Large Dog step: " + step);
            }
        }
    }

    public static void test_mdog() {
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
            double dStep = Animal.human_to_mdog(num, unit);
            if (dStep < 1){
                System.out.println("Large Dog step: " + String.format("%.2f", dStep));
            }else{
                int step = (int)dStep;
                System.out.println("Large Dog step: " + step);
            }
        }
    }
    
    public static void test_sdog() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What measurement you want it in:\n1. inches\n2. cm");
            int option = scanner.nextInt();
            String unit = "";
            if (option == 1) unit = "inches";
            if (option == 2) unit = "cm";
            System.out.print("Human Step: ");
            int num = scanner.nextInt();
            double dStep = Animal.human_to_sdog(num, unit);
            if (dStep < 1){
                System.out.println("Large Dog step: " + String.format("%.2f", dStep));
            }else{
                int step = (int)dStep;
                System.out.println("Large Dog step: " + step);
            }
        }
    }

    public static void test_kangaroo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What measurement you want it in:\n1. inches\n2. cm");
            int option = scanner.nextInt();
            String unit = "";
            if (option == 1) unit = "inches";
            if (option == 2) unit = "cm";
            System.out.print("Human Step: ");
            int num = scanner.nextInt();
            double kStep = Animal.human_to_kangaroo(num, unit);
            if (kStep < 1){
                System.out.println("Kangaroo step: " + String.format("%.2f", kStep));
            }else{
                int step = (int)kStep;
                System.out.println("Kangaroo step: " + step);
            }
        }
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What do you want to test (pick a number):");
            System.out.println(" 1. cat ");
            System.out.println(" 2. dog paw");
            System.out.println(" 3. elephant");
            System.out.println(" 4. horse");
            System.out.println(" 5. dog");
            System.out.println(" 6. kangaroo");
            System.out.println(" 7. sqirrel");
            System.out.println(" 8. ");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    test_cat();
                    break;
                case 2:
                    test_dog_paw();
                    break;
                case 3:
                    test_elephant();
                    break;
                case 4:
                    test_horse();
                    break;
                case 5:
                    System.out.println("What size dog:\n1.Large\n2.Medium\n3.Small");
                    int size = scanner.nextInt();
                    if(size == 1) test_ldog();
                    if(size == 2) test_mdog();
                    if(size == 3) test_sdog();
                    break;
                case 6:
                    test_kangaroo();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("No matching case");
                    break;
            }
        }
    }
}
