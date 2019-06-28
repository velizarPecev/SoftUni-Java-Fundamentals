import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Retire!")){
            String[] commands = input.split(" - ");

            if (commands[0].equals("Start")){

                if (stringList.contains(commands[1])){

                }else{
                    stringList.add(commands[1]);
                }
            }
            if (commands[0].equals("Complete")){
                if (stringList.contains(commands[1])){
                    stringList.remove(commands[1]);
                }
            }
            if (commands[0].equals("Side Quest")){
                String[] sides = commands[1].split(":");
                String quest = sides[0];
                String sideQuest = sides[1];
                if(stringList.contains(quest) && !stringList.contains(sideQuest)){
                    int index = stringList.indexOf(quest) + 1;
                    stringList.add(index, sideQuest);
                }
            }
            if (commands[0].equals("Renew")){
                if (stringList.contains(commands[1])){
                    stringList.remove(commands[1]);
                    stringList.add(commands[1]);
                }
            }
            input=scanner.nextLine();
        }
        System.out.println(String.join(", ",stringList));
    }
}
