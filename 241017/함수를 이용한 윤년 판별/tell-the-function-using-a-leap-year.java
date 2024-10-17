import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println(isYoonYear(year));
    }

    public static boolean isYoonYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        return true;
    }
}