import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] A = new int[a];
        int[] B = new int[b];

        for(int i = 0; i < a; i++) {
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < b; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(B);
        int commonCount = 0;
        for(int target : A) {
            int low = 0;
            int high = B.length - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if (target == B[mid]) {
                    commonCount++;
                    break;
                } else if (target < B[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        System.out.println((A.length - commonCount) + (B.length - commonCount));
    }
}
