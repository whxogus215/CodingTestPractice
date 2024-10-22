import java.util.*;

public class Main {

    public static int[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public static int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int D = sc.nextInt();

        if (isExist(M, D)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isExist(int M, int D) {
        for(int i = 0; i < 12; i++) {
            if (M == month[i] && D <= day[i]) {
                return true;
            }
        }
        return false;
    }
}