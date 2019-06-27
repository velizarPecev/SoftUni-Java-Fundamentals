import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int countOfPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayForPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayForPerson = Double.parseDouble(scanner.nextLine());

        double energyFromWater = days * countOfPlayers * waterPerDayForPerson;
        double energyFromFood = days * countOfPlayers * foodPerDayForPerson;

       boolean ready = true;
        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());

            groupEnergy -= energyLoss;

            if (groupEnergy<=0){
                ready = false;
                break;
            }
            if (i % 2 == 0) {
                groupEnergy += 0.05 * groupEnergy;
                energyFromWater -= energyFromWater * 0.3;
            }
            if (i % 3 == 0) {
                groupEnergy += groupEnergy * 0.1;
                energyFromFood -= energyFromFood / (double) countOfPlayers;
            }
        }
        if (ready) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", energyFromFood, energyFromWater);
        }
    }
}
