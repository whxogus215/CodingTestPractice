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
        int nPos;
        for (int j = 0; j < N; j++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d == 'L') {
                nPos = cPos - (x - 1);
                for(int i = nPos; i <= cPos; i++) {
                    if (tiles[i] == 'G') {
                        continue;
                    }
                    white[i]++;
                    if (isGrey(i)) {
                        tiles[i] = 'G';
                    } else {
                        tiles[i] = 'W';
                    }
                }
            } else {
                nPos = cPos + (x - 1);
                for(int i = cPos; i <= nPos; i++) {
                    if (tiles[i] == 'G') {
                        continue;
                    }
                    black[i]++;
                    if (isGrey(i)) {
                        tiles[i] = 'G';
                    } else {
                        tiles[i] = 'B';
                    }
                }
            }

            cPos = nPos;
        }

        int whiteCount = 0, blackCount = 0, greyCount = 0;
        for(int i = 0; i < tiles.length; i++) {
            if (tiles[i] == 'W') {
                whiteCount++;
            } else if (tiles[i] == 'B') {
                blackCount++;
            } else if (tiles[i] == 'G') {
                greyCount++;
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