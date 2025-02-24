import java.util.Scanner;
public class Main {

    public static int N = 100;

    public static int[] x = new int[N];
    public static int[] y = new int[N];

    public static int distanceX;
    public static int distanceY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if (isParellel(i, j, k)) {
                        max = Math.max(max, getTriangle(i, j, k));    
                    }
                }
            }
        }
        System.out.println(max * 2);
    }

    public static boolean isParellel(int i, int j, int k) {
        boolean isParellelX = y[i] == y[j] || y[i] == y[k] || y[j] == y[k];
        boolean isParellelY = x[i] == x[j] || x[i] == x[k] || x[j] == x[k];
        return isParellelX && isParellelY;
    }

    public static int getTriangle(int i, int j, int k) {
        int distanceX = 0;
        int distanceY = 0;

        int[] dx = {Math.abs(x[i] - x[j]), Math.abs(x[i] - x[k]), Math.abs(x[j] - x[k])};
        int[] dy = {Math.abs(y[i] - y[j]), Math.abs(y[i] - y[k]), Math.abs(y[j] - y[k])};

        distanceX = Math.max(dx[0], Math.max(dx[1], dx[2]));
        distanceY = Math.max(dy[0], Math.max(dy[1], dy[2]));

        return (distanceX * distanceY) / 2;
    }
}