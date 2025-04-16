import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        int cnt = binary.length();
        int[] digits = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            digits[i] = binary.charAt(i) - '0';
        }

        int sum = 0;
        for(int i = 0; i < cnt; i++) {
            sum = sum * 2 + digits[i];
        }
        System.out.println(sum);
    }
}