import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        int[] lis = new int[N];
        int lastIndex = 0;
        lis[lastIndex] = arr[0][1];

        for(int i = 1; i < N; i++) {
            if (lis[lastIndex] < arr[i][1]) {
                lis[++lastIndex] = arr[i][1];
            } else {
                int left = 0;
                int right = lastIndex;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if (lis[mid] < arr[i][1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                lis[left] = arr[i][1];
            }
        }

        int lisLength = lastIndex + 1;

        System.out.println(N - lisLength);
    }
}
