import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(getSum(a * b * c));        
    }

    public static int getSum(int num) {
        if (num < 10) {
            return num;
        }
        return getSum(num / 10) + num % 10;
    }
}