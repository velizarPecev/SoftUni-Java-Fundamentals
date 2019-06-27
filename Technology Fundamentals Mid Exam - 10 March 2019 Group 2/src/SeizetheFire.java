import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeizetheFire {

    static boolean isFire (String type, int cell){
        switch (type){
            case "High":
                return 81<=cell&&cell<=125;
            case"Medium":
                return 51<=cell&&cell<=80;
            case "Low":
                return 1<=cell&&cell<=50;
                default:
                    return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> fires = Arrays.stream(scanner.nextLine().split("#")).collect(Collectors.toList());

        int water = Integer.parseInt(scanner.nextLine());

        List<Integer> cells = new ArrayList<>();

        double effort = 0;
        int totalFire = 0;

        for (int i = 0; i < fires.size(); i++) {

            String type = fires.get(i).split(" = ")[0];
            int cell = Integer.parseInt(fires.get(i).split(" = ")[1]);

            if (isFire(type,cell)&&water>=cell) {
                cells.add(cell);
                effort += cell * 0.25;
                totalFire += cell;
                water -= cell;
            }

        }
        System.out.println("Cells:");
        for (int cell : cells)
        {
            System.out.printf(" - %d%n",cell);
        }
        System.out.printf("Effort: %.2f%n",effort);
        System.out.printf("Total Fire: %d",totalFire);
    }
}
