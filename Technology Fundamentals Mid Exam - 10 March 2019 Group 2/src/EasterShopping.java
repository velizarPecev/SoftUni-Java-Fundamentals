import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "Include":
                    shops.add(command[1]);
                    break;
                case "Visit":
                    int number = Integer.parseInt(command[2]);
                    if (number <= shops.size()) {

                        if (command[1].equals("first")) {
                            for (int j = 0; j < number; j++) {
                                shops.remove(0);
                            }
                            break;
                        } else {
                            for (int j = 0; j < number; j++) {
                                shops.remove(shops.size() - 1);
                            }
                            break;
                        }
                    }
                    break;

                case "Prefer":
                    int shop1Index = Integer.parseInt(command[1]);
                    int shop2Index = Integer.parseInt(command[2]);
                    if (shop1Index < shops.size() && shop2Index < shops.size()) {
                        String shop1 = shops.get(shop1Index);
                        String shop2 = shops.get(shop2Index);
                        shops.remove(shop1);
                        shops.add(shop1Index, shop2);
                        shops.remove(shop2Index);
                        shops.add(shop2Index, shop1);
                        break;
                    }
                case "Place":
                    String shop = command[1];
                    int shopIndex = Integer.parseInt(command[2]);
                    if (shopIndex + 1 < shops.size()) {
                        shops.add(shopIndex + 1, shop);
                    }
                    break;

            }
        }
        System.out.println("Shops left:");
        shops = shops.stream().filter(e -> !e.equals("None")).collect(Collectors.toList());
        System.out.println(shops.toString().replaceAll("[\\[\\],]", ""));
    }
}
