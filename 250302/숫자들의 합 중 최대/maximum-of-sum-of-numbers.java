import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int maxSum = 1;
        for(int num = X; num <= Y; num++) {
            int sum = 0;
            for(int i = 0; i <= 4; i++) {
                int child = (int) Math.pow(10, i); 
                int digit = (num / child) % 10;

                sum += digit;                
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}