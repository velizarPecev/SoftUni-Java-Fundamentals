import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceForFlour = Double.parseDouble(scanner.nextLine());
        double priceForEgg = Double.parseDouble(scanner.nextLine());
        double priceFroApron = Double.parseDouble(scanner.nextLine());

        double freePackages = students/5;
        double neededItems = priceFroApron * Math.ceil(students * 1.2) + priceForEgg * 10 * (students) + priceForFlour * (students - freePackages);

        if (budget>=neededItems){
            System.out.printf("Items purchased for %.2f$.",neededItems);
        }else {
            System.out.printf("%.2f$ more needed.",neededItems-budget);
        }
    }
}