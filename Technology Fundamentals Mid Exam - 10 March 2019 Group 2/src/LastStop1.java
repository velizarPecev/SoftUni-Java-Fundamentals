import java.util.*;
import java.util.stream.Collectors;

public class LastStop1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split(" ");
            String type = commands[0];

            switch (type) {
                case "Change":
                    String currNumber = commands[1];
                    String secondNumber = commands[2];
                    int index = 0;
                    if (numbers.contains(currNumber)) {
                        index = numbers.indexOf(currNumber);
                    }
                    numbers.set(index, secondNumber);
                    break;
                case "Hide":
                    String cNumber = commands[1];
                    if (numbers.contains(commands[1])) {
                        numbers.remove(cNumber);
                    }
                    break;
                case "Switch":
                    String Number = commands[1];
                    String secNumber = commands[2];
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i).equals(Number)) {
                            numbers.set(i, secNumber);
                        } else if (numbers.get(i).equals(secNumber)) {
                            numbers.set(i, Number);
                        }
                    }
                    break;
                case "Insert":
                    if (Integer.parseInt(commands[1]) > -1 && Integer.parseInt(commands[1]) < numbers.size()) {
                        numbers.add(Integer.parseInt(commands[1]) + 1, commands[2]);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ",numbers));
    }
}
