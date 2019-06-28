import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hp = 100;
        int coins = 0;
        int room = 1;
        String[] rooms = scanner.nextLine().split("\\|");
        List<String> items = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (var a : rooms) {
            String[] things = a.split(" ");
            items.add(things[0]);
            values.add(Integer.parseInt(things[1]));
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals("potion")) {
                int bonus = values.get(i);
                if (hp + bonus < 100) {
                    System.out.printf("You healed for %d hp.%n", bonus);
                    hp += bonus;
                } else {
                    System.out.printf("You healed for %d hp.%n", 100 - hp);
                    hp = 100;
                }
                System.out.printf("Current health: %d hp.%n", hp);
                room++;
            } else if (items.get(i).equals("chest")) {
                int bonus = values.get(i);
                coins += bonus;
                System.out.printf("You found %d coins.%n",bonus);
                room++;
            } else {
                int bonus = values.get(i);
                hp -= bonus;
                if (hp > 0) {
                    System.out.printf("You slayed %s.%n",items.get(i));
                    room++;
                } else {
                    System.out.printf("You died! Killed by %s.%n",items.get(i));
                    System.out.printf("Best room: %d%n",room);
                    break;
                }
            }
        }
        if (hp > 0) {
            System.out.printf("You've made it!\nCoins: %d\nHealth: %d",coins,hp);
        }
    }
}
