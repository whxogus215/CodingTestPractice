import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            p[i] /= 2;

            int[] copy = Arrays.copyOf(p, p.length);
            Arrays.sort(copy);

            int price = b;
            int count = 0;
            for(int j = 0; j < n; j++) {
                if (price < copy[j]) {
                    break;
                }
                count++;
                price -= copy[j];
            }

            max = Math.max(max, count);

            p[i] *= 2;
        }

        System.out.println(max);
    }
}