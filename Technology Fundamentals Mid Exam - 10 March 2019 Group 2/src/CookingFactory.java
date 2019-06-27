import java.util.Arrays;
import java.util.Scanner;

public class CookingFactory {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] bakeInt = Arrays.stream(scan.nextLine().split("#")).mapToInt(Integer::parseInt).toArray();
        int[] keepInt = bakeInt;

        while (true){
            String readLine = scan.nextLine();
            if("Bake It!".equals(readLine)) break;
            bakeInt = Arrays.stream(readLine.split("#")).mapToInt(Integer::parseInt).toArray();
            if(Arrays.stream(bakeInt).sum() > Arrays.stream(keepInt).sum()){
                keepInt = bakeInt;
            }
            else if(Arrays.stream(bakeInt).sum() == Arrays.stream(keepInt).sum()){
                if(Arrays.stream(bakeInt).sum() >= 0){
                    if(bakeInt.length < keepInt.length){
                        keepInt = bakeInt;
                    }
                }
                else {
                    if(bakeInt.length > keepInt.length){
                        keepInt = bakeInt;
                    }
                }
            }
        }

        System.out.println("Best Batch quality: " + Arrays.stream(keepInt).sum());
        Arrays.stream(keepInt).forEach(x -> System.out.printf("%d ", x));
    }
}