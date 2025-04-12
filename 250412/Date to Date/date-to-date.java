import java.util.Scanner;
public class Main {

    public static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int firstDays = d1, secondDays = d2;
        for(int i = 1; i < m1; i++) {
            firstDays += months[i];
        }
        for(int i = 1; i < m2; i++) {
            secondDays += months[i];
        }

        System.out.println(secondDays - firstDays + 1);
    }
}