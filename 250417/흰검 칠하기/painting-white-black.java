import java.util.Scanner;
public class Main {

    public static final int OFFSET = 99000;

    public static char[] tiles = new char[OFFSET * 2 + 1];
    public static int[] black = new int[OFFSET * 2 + 1];
    public static int[] white = new int[OFFSET * 2 + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cPos = OFFSET;
        for (int j = 0; j < N; j++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d == 'L') {
                while(x-- > 0) {
                    tiles[cPos] = 'W';
                    white[cPos]++;
                    if (x > 0) {
                        cPos--;
                    }
                }
            } else {
                while(x-- > 0) {
                    tiles[cPos] = 'B';
                    black[cPos]++;
                    if (x > 0) {
                        cPos++;
                    }
                }
            }
        }

        int whiteCount = 0, blackCount = 0, greyCount = 0;
        for(int i = 0; i < tiles.length; i++) {
            if (isGrey(i)) {
                greyCount++;
                continue;
            }
            if (tiles[i] == 'W') {
                whiteCount++;
            } else if (tiles[i] == 'B') {
                blackCount++;
            }
        }

        System.out.println(whiteCount + " " + blackCount + " " + greyCount);
    }

    public static boolean isGrey(int index) {
        if (black[index] >= 2 && white[index] >= 2) {
            return true;
        }
        return false;
    }
}