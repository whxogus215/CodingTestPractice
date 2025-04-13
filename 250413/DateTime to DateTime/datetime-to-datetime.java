import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.

        int standardTime = 24 * 60 * 11 + 60 * 11 + 11;
        int compareTime = 24 * 60 * A + 60 * B + C;

        int result = compareTime - standardTime;
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}