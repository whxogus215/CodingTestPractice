import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        if (isOverlapp(x1, y1, x2, y2, a1, b1, a2, b2)) {
            System.out.println("overlapping");
        } else {
            System.out.println("nonoverlapping");
        }
    }

    public static boolean isOverlapp(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        if (x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1) {
            return false;
        }
        return true;
    }
}