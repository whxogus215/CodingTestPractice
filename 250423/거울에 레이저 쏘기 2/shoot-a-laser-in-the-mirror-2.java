import java.util.Scanner;

public class Main {

    public static final int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int n, currentX, currentY, currentDIR, count;
    public static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();

        initializeCurrent(startNum);
        simulate();        
        System.out.println(count);
    }

    public static void initializeCurrent(int startNum) {
        if (startNum > 0 && startNum <= n) {
            currentY = 0;
            currentX = startNum - 1;
            currentDIR = 1;
        } else if (startNum <= 2*n) {
            currentY = startNum - (n + 1);
            currentX = n - 1;
            currentDIR = 2;
        } else if (startNum <= 3*n) {
            currentY = n - 1;
            currentX = startNum - (n + 2*(startNum % (2*n)));
            currentDIR = 3;
        } else if (startNum <= 4*n) {
            currentY = startNum - (2*n + 2*(startNum % (3*n)));
            currentX = 0;
            currentDIR = 0;
        }
    }

    public static void simulate() {
        while(inRange(currentX, currentY)) {
            count++;
            if (grid[currentY][currentX] == '/') {
                currentDIR = 3 - currentDIR;
            } else { // \일 때
                currentDIR = currentDIR ^ 1;
            }
            currentX = currentX + dx[currentDIR];
            currentY = currentY + dy[currentDIR];
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}