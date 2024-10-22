import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arrN1 = new int[n1];
        int[] arrN2 = new int[n2];

        for(int i = 0; i < arrN1.length; i++) {
            arrN1[i] = sc.nextInt();
        }

        for(int i = 0; i < arrN2.length; i++) {
            arrN2[i] = sc.nextInt();
        }

        System.out.println(isContinue(arrN1, arrN2));
    }

    public static String isContinue(int[] arrN1, int[] arrN2) {
        if (isYes(arrN1, arrN2)) {
            return "Yes";
        }
        return "No";
    }

    public static boolean isYes(int[] arrN1, int[] arrN2) {
        int start = getIndex(arrN1, arrN2);
        if (start == -1) {
            return false;
        }
        int j = start;
        for(int i = 0; i < arrN2.length; i++) {
            if (arrN2[i] != arrN1[j]) {
                return false;
            }
        }
        return true;                            
    }

    public static int getIndex(int[] arrN1, int[] arrN2) {
        for(int i = 0; i < arrN1.length; i++) {
            if (arrN1[i] == arrN2[0]) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}