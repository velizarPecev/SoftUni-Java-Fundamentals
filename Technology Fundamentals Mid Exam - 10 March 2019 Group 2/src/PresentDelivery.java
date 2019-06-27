
import java.util.Arrays;

import java.util.Scanner;


public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        int currentPosition = 0;

        while (!input.equals("Merry Xmas!")) {

            String[] command = input.split(" ");
            currentPosition = (currentPosition + Integer.parseInt(command[1])) % houses.length;

            if (houses[currentPosition] != 0) {
                houses[currentPosition] -= 2;
            } else {
                System.out.printf("House %d will have a Merry Christmas.\n", currentPosition);
            }
            input = scanner.nextLine();
        }
        if (Arrays.stream(houses).sum() == 0) {
            System.out.printf("Santa's last position was %d.\nMission was successful.", currentPosition);
        } else {
            houses = Arrays.stream(houses).filter(e -> e > 0).toArray();
            System.out.printf("Santa's last position was %d.\nSanta has failed %d houses.", currentPosition, houses.length);
        }
    }
}

