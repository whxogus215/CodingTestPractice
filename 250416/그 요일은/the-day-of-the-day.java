import java.util.*;

public class Main {

    public static Map<String, Integer> days = new HashMap<String, Integer>() {
            {
                put("Mon", 0);
                put("Tue", 1);
                put("Wed", 2);
                put("Thu", 3);
                put("Fri", 4);
                put("Sat", 5);
                put("Sun", 6);
            }
            
        };
    public static int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();

        int standardDays = 0, compareDays = 0;
        for(int i = 1; i < m1; i++) {
            standardDays += months[i];
        }
        standardDays += d1;
        standardDays += days.get(A);

        for(int i = 1; i < m2; i++) {
            compareDays += months[i];
        }
        compareDays += d2;

        int dayCount = 0;
        dayCount = (compareDays - standardDays) / 7 + 1;
        System.out.println(dayCount);
    }
}