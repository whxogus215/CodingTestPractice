import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];

        for(int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        
        int total = 0;

        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    
                    boolean success = true;
                    for(int l = 0; l < N; l++) {
                        int cnt1 = 0;
                        int cnt2 = 0;

                        int first = a[l] / 100;
                        int second = a[l] / 10 % 10;
                        int third = a[l] % 10;

                        if (i == first) {
                            cnt1++;
                        }
                        if (j == second) {
                            cnt1++;
                        }
                        if (k == third) {
                            cnt1++;
                        }
                        if (i == second || i == third) {
                            cnt2++;
                        }
                        if (j == first || j == third) {
                            cnt2++;
                        }
                        if (k == first || k == second) {
                            cnt2++;
                        }

                        if (cnt1 != b[l] || cnt2 != c[l]) {
                            success = false;
                            break;
                        }
                    }

                    if (success) {
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}