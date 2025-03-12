import java.util.*;

public class Main {

    public static TreeSet<Integer> tree = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] commands = line.split(" ");
            System.out.println(Arrays.toString(commands));
            if (commands.length == 2) {
                go(commands[0], Integer.parseInt(commands[1]));
            } else {
                go(line, 0);
            }
        }
    }

    public static void go(String command, int number) {
        if ("add".equals(command)) {
            tree.add(number);
        } else if ("remove".equals(command)) {
            tree.remove(number);
        } else if ("find".equals(command)) {
            if (tree.contains(number)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } else if ("lower_bound".equals(command)) {
            if (tree.ceiling(number) != null) {
                System.out.println(tree.ceiling(number));
            } else {
                System.out.println("None");
            }
        } else if ("upper_bound".equals(command)) {
            if (tree.higher(number) != null) {
                System.out.println(tree.higher(number));
            } else {
                System.out.println("None");
            }
        } else if ("largest".equals(command)) {
            if (!tree.isEmpty()) {
                System.out.println(tree.last());
            } else {
                System.out.println("None");
            }
        } else {
            if (!tree.isEmpty()) {
                System.out.println(tree.first());
            } else {
                System.out.println("None");
            }
        }
    }
}