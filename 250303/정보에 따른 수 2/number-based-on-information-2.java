import java.util.*;

public class Main {
    
    public static int MAX = 1000;
    public static int T, a, b;
    public static int[] positions;
    public static char[] alphabets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        positions = new int[T];
        alphabets = new char[MAX + 1];
        for(int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int x = sc.nextInt();

            positions[i] = x;
            alphabets[x] = c;
        }

        int specialCount = 0;
        for(int k = a; k <= b; k++) {
            int d1 = MAX, d2 = MAX;
            for(int i = 0; i < T; i++) {
                int position = positions[i];
                char alphabet = alphabets[position];

                int distance = Math.abs(position - k);
                if (alphabet == 'S') {
                    d1 = Math.min(d1, distance);
                } else {
                    d2 = Math.min(d2, distance);
                }
            }
            if (d1 <= d2) {
                specialCount++;
            }
        }

        System.out.println(specialCount);
    }
}