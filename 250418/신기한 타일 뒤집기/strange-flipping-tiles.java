import java.util.Scanner;
public class Main {

    public static final char WHITE = 'W';
    public static final char BLACK = 'B';

    public static final int OFFSET = 100000;
    public static char[] tiles = new char[OFFSET * 2 + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cPos = OFFSET;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d == 'L') {
                while(x-- > 0) {
                    tiles[cPos] = WHITE;
                    if (x > 0) {
                        cPos--;
                    }
                }
            } else {
                while(x-- > 0) {
                    tiles[cPos] = BLACK;
                    if (x > 0) {
                        cPos++;
                    }
                }
            }
        }

        int whiteCount = 0, blackCount = 0;
        for(int i = 0; i < tiles.length; i++) {
            if (tiles[i] == BLACK) {
                blackCount++;
            }
            if (tiles[i] == WHITE) {
                whiteCount++;
            }
        }
        System.out.println(whiteCount + " " + blackCount);
    }
}