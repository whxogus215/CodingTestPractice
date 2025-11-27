import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] lis = new int[N];
        int lastIndex = 0;
        lis[lastIndex] = arr[0];
        
        for(int i = 1; i < N; i++) {
            if (arr[i] > lis[lastIndex]) {
                lis[++lastIndex] = arr[i];
            } else {
                // 이분 탐색
                int left = 0;
                int right = lastIndex;
                int index = lastIndex + 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if (lis[mid] >= arr[i]) {
                        index = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lis[index] = arr[i];
            }
        }
        
        System.out.println(lastIndex + 1);
    }
}
