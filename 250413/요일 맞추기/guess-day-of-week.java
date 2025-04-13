import java.util.Scanner;
public class Main {

    public static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int standardDays = d1;
        int compareDays = d2;

        for(int i = 1; i < m1; i++) {
            standardDays += months[i];
        }
        for(int i = 1; i < m2; i++) {
            compareDays += months[i];
        }

        int idx = standardDays % 7;
        String[] newDays = new String[7];
        for(int i = 0; i < 7; i++) {
            if (idx >= 7) {
                idx = 0;
            }
            newDays[idx++] = days[i];
        }

        System.out.println(newDays[compareDays % 7]);
    }
}