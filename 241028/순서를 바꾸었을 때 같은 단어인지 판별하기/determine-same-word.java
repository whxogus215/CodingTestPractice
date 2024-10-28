import java.util.*;

public class Main {

    public static String a;
    public static String b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();

        if (isSame()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isSame() {
        if (a.length() != b.length()) {
            return false;
        }
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for(int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                return false;
            }
        }
        return true;
    }
}