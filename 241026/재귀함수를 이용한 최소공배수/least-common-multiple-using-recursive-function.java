import java.util.*;

public class Main {
    
    public static int MAX_N = 10;
    public static int[] arr = new int[MAX_N];
    public static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getLCMAll(n - 1));
    }

    // index번째 까지 인덱스의 숫자 중에 가장 큰 값을 반환한다.
    public static int getLCMAll(int index) {
        if (index == 0) {
            return arr[0];
        }
        return lcm(getLCMAll(index - 1), arr[index]);
    }

    public static int lcm(int a, int b) {
        int result = 1;
        for(int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return a * b / result;
    }
}