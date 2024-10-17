import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getSumPrimes(a, b));
    }

    public static int getSumPrimes(int a, int b) {
        int sum = 0;
        for(int i = a; i <= b; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        // number가 1가 number 이외에 수로 나누어 떨어지지 않으면 소수이다.
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
}