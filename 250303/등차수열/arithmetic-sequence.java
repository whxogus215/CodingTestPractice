import java.util.*;

public class Main {
    
    public static int N;
    public static int[] numbers;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int ai = numbers[i];
                int aj = numbers[j];

                for(int k = 1; k <= 100; k++) {
                    if ((k - ai) == (aj - k)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}