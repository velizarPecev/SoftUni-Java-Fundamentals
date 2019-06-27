import java.util.Scanner;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] events = scanner.nextLine().split("[|]");
        double energy = 100;
        double coins = 100;
        for (int i = 0; i < events.length; i++) {
            String[] event = events[i].split("-");

            String name = event[0];
            Double number = Double.parseDouble(event[1]);

            if (name.equals("rest")){
                if (energy==100) {
                    System.out.println("You gained 0 energy.");
                    System.out.printf("Current energy: %.0f.%n", energy);
                }else if (energy + number > 100) {
                    System.out.printf("You gained %.0f energy.%n", energy + number - 100);
                    System.out.println("Current energy: 100.");
                    energy = 100;
                }
                else {
                    energy += number;
                    System.out.printf("You gained %.0f energy.%n", number);
                    System.out.printf("Current energy: %.0f.%n", energy);
                }
            }else if (name.equals("order")){
                if (energy>=30){
                    energy -= 30;
                    coins += number;
                    System.out.printf("You earned %.0f coins.%n",number);
                }
                else {
                    energy+=50;
                    System.out.println("You had to rest!");
                }
            }else{
                if (coins-number>0){
                    coins-=number;
                    System.out.printf("You bought %s.%n", name);
                }else {
                    System.out.printf("Closed! Cannot afford %s.%n", name);
                    return;
                }
            }
        }
        System.out.println("Day completed!");
        System.out.printf("Coins: %.0f%n", coins);
        System.out.printf("Energy: %.0f%n", energy);
    }
}
