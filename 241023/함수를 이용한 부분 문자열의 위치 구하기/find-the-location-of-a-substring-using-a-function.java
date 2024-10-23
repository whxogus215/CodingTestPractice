import java.util.*;

public class Main {

    public static String input;
    public static String object;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.next();
        object = sc.next();

        System.out.println(isContain());
    }

    public static int isContain() {
        for(int i = 0; i <= input.length() - object.length(); i++) {
            if (object.equals(input.substring(i, i + object.length()))) {
                return i;
            }
        }
        return -1;
    }
}