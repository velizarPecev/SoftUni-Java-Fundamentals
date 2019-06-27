import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int companions = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int allCoins = days*50;
        for (int i = 1; i <= days; i++) {


            if (i % 10 == 0) {
                companions -= 2;
            }
            if (i % 15 == 0) {
                companions += 5;
            }

            if (i % 3 == 0) {
               allCoins -= 3*companions;
            }
            if (i % 5 == 0) {
                int earnedCoins = 20;
                allCoins += earnedCoins * companions;

                if (i % 3 == 0) {
                    allCoins -= companions * 2;
                }
            }
            allCoins -= companions * 2;
        }
        int coinsPerPerson = allCoins / companions;
        System.out.printf("%d companions received %d coins each.", companions, coinsPerPerson);
    }
}
