import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isDifferent(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isDifferent(String input) {
        char[] arr = new char[input.length()];

        char value = ' ';
        int index = 0;
        arr[0] = input.charAt(0);
        A:for(int i = 1; i < input.length(); i++) {
            value = input.charAt(i);
            for(int j = 0; j < index + 1; j++) {
                if (arr[j] == value) {
                    continue A;
                }
            }
            arr[++index] = value;
        }

        if (index + 1 >= 2) {
            return true;
        }
        return false;
    }
}