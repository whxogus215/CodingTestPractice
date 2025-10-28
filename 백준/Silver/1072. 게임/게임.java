import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();

        long Z = (Y * 100) / X;

        long left = 1;
        long right = 2_000_000_000;
        long result = -1;

        if (X == Y) {
            System.out.println(result);
            return ;
        }
        while(left <= right) {
            long mid = left + (right - left) / 2;

            long newZ = (Y + mid) * 100 / (X + mid);

            if (newZ > Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
