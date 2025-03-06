import java.util.*;

public class Main {
    
    public static int N;
    public static int[] arrX;
    public static int[] arrY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arrX = new int[N];
        arrY = new int[N];

        for(int i = 0; i < N; i++) {
            arrX[i] = sc.nextInt();
            arrY[i] = sc.nextInt();
        }

        int minPointCount = N;
        for(int x = 0; x <= 100; x += 2) {
            for(int y = 0; y <= 100; y += 2) {
                int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
                for(int l = 0; l < N; l++) {
                    if (arrX[l] < x && arrY[l] > y) {
                        count1++;
                    }
                    if (arrX[l] > x && arrY[l] > y) {
                        count2++;
                    }
                    if (arrX[l] < x && arrY[l] < y) {
                        count3++;
                    }
                    if (arrX[l] > x && arrY[l] < y) {
                        count4++;
                    }
                }
                int max1 = Math.max(count1, count2);
                int max2 = Math.max(max1, count3);
                int maxCount = Math.max(max2, count4);
                minPointCount = Math.min(minPointCount, maxCount);
            }
        }

        System.out.println(minPointCount);
    }
}