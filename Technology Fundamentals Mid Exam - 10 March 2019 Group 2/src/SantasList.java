import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> childs = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Finished!")){
            String[] qualities = command.split(" ");

            if (qualities[0].equals("Bad")){
                if (childs.contains(qualities[1])){

                }else {
                    childs.add(0,qualities[1]);
                }
            }else if (qualities[0].equals("Good")){
                if (childs.contains(qualities[1])){
                    childs.remove(qualities[1]);
                }
            }else if (qualities[0].equals("Rename")){
                String oldName = qualities[1];
                String newName = qualities[2];
                if (childs.contains(oldName)){
                    int index = childs.indexOf(oldName);
                    childs.set(index,newName);
                }
            }else if (qualities[0].equals("Rearrange")){
                if (childs.contains(qualities[1])){
                    childs.remove(qualities[1]);
                    childs.add(qualities[1]);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ",childs));
    }
}
