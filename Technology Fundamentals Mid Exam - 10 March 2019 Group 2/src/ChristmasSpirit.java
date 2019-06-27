import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int ornaments = 0;
        int treeSkirt = 0;
        int treeGerlands = 0;
        int treeLights = 0;

        int spirit = 0;
        for (int i = 1; i <= days; i++) {

            if (i%11==0){
                quantity += 2;
            }

            if (i%2==0){
                ornaments += quantity*2;
                spirit += 5;
            }
            if (i%3==0){
                treeSkirt += quantity*5;
                treeGerlands += quantity*3;
                spirit += 13;
            }
            if (i%5==0){
                treeLights += quantity*15;
                spirit += 17;
            }

            if (i%3==0&&i%5==0){
                spirit += 30;
            }
            if (i%10==0){
                spirit -= 20;
                ornaments += 23;
                if (i == 10 && days % 10 == 0)  // when last days is a tenth day !
                {
                    spirit -= 30;
                }
            }
        }

        int total = ornaments+treeSkirt+treeGerlands+treeLights;

        System.out.printf("Total cost: %d%n",total);
        System.out.printf("Total spirit: %d",spirit);
    }
}
