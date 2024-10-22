import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0;
        for(int i = a; i <= b; i++) {
            if (isSosu(i) && isJjaksu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isSosu(int number) {
        if (number == 1) {
            return false;
        }
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isJjaksu(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }
        if (sum % 2 ==0) {
            return true;
        }
        return false;
    }
}