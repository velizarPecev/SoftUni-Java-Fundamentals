import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        double priceForFuel = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());
        double priceForRoomPerPerson = Double.parseDouble(scanner.nextLine());

        if (people > 10) {
            priceForRoomPerPerson *= 0.75;
        }

        double expenses = days * people * (foodPerPerson + priceForRoomPerPerson);

        for (int i = 1; i <= days; i++) {
            double distance = Double.parseDouble(scanner.nextLine());

            expenses += distance * priceForFuel;

            if (i % 3 == 0 || i % 5 == 0) {
                expenses *= 1.4;
            } else if (i % 7 == 0) {
                expenses -= expenses / people;

            }

            if (budget < expenses) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", expenses - budget);
                return;
            }
        }

        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - expenses);

    }
}