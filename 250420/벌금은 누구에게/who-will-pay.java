import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] person = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int number = sc.nextInt();
            person[number]++;
            if (person[number] >= k) {
                System.out.println(number);
                return;
            }
        }
    }
}