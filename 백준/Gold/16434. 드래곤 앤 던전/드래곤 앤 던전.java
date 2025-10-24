import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int[][] roomInfo;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long humanAttack = sc.nextLong();

        roomInfo = new int[N][3];
        for(int i = 0; i < roomInfo.length; i++) {
            roomInfo[i][0] = sc.nextInt();
            roomInfo[i][1] = sc.nextInt();
            roomInfo[i][2] = sc.nextInt();
        }

        long maxHP = 1;
        long low = 1;
        long high = Long.MAX_VALUE;

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if (isSurvived(mid, humanAttack)) {
                maxHP = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(maxHP);
    }

    private static boolean isSurvived(long maxHP, long humanAttack) {
        long humanHP = maxHP;
        for(int i = 0; i < roomInfo.length; i++) {
            int t = roomInfo[i][0];
            if (t == 1) {
                long monsterAttack = roomInfo[i][1];
                long monsterHP = roomInfo[i][2];
    
                long myAttackCount = monsterHP / humanAttack;
                if (monsterHP % humanAttack != 0) {
                    myAttackCount++;
                }
                long monsterAttackCount = myAttackCount - 1;
                humanHP -= (monsterAttackCount * monsterAttack);
                
                if (humanHP <= 0) {
                    return false;
                }
            } else {
                humanAttack += roomInfo[i][1];
                humanHP = Math.min(humanHP + roomInfo[i][2], maxHP);
            }
        }
        return true;
    }
}
