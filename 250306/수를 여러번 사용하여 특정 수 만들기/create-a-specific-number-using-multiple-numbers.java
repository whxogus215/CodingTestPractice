import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int max = 0;
        for(int i = 0; i * A <= C; i++) {
            for(int j = 0; j * B <= C; j++) {
                int sum = A * i + B * j; 
                if (sum > C) {
                    break ;
                }
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}