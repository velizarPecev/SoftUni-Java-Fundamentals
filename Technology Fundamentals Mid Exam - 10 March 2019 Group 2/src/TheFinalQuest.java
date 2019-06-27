import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] com = command.split(" ");

            if (com[0].equals("Delete")) {
                int index = Integer.parseInt(com[1]) + 1;
                if (index < stringList.size()) {
                    stringList.remove(index);
                }
            }
            if (com[0].equals("Swap")) {
                boolean wordOne = false;
                boolean wordTwo = false;
                for (int i = 0; i < stringList.size(); i++) {

                    if (stringList.get(i).contains(com[1])) {
                        wordOne = true;
                    }
                    if (stringList.get(i).contains(com[2])) {
                        wordTwo = true;
                    }
                    if (wordOne && wordTwo) {
                        int b = stringList.indexOf(com[2]);
                        int c = stringList.indexOf(com[1]);

                        stringList.set(c, com[2]);
                        stringList.set(b, com[1]);
                        break;

                    }
                }
            }
            if (com[0].equals("Put")) {
                String word = com[1];
                int index = Integer.parseInt(com[2]) - 1;
                if (index >= 0 && index <= stringList.size()) {
                    stringList.add(index, word);
                }
            }
            if (com[0].equals("Sort")) {
                Collections.sort(stringList, Collections.reverseOrder());
            }
            if (com[0].equals("Replace")) {
                boolean isHere = false;
                for (int i = 0; i < stringList.size(); i++) {
                    if (com[2].contains(stringList.get(i))) {
                        isHere = true;
                    }
                    if (isHere) {
                        int d = stringList.indexOf(com[2]);
                        stringList.set(d, com[1]);
                        break;
                    }

                }
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ",stringList));
    }
}