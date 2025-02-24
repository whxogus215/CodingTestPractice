import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int a1, a2, b1, b2;
                if (x1[i] < x1[j]) {
                    a1 = x1[i]; a2 = x2[i];
                    b1 = x1[j]; b2 = x2[j];
                } else {
                    a1 = x1[j]; a2 = x2[j];
                    b1 = x1[i]; b2 = x1[i];
                }

                if (a2 > b2) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            if (count[i] == 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}