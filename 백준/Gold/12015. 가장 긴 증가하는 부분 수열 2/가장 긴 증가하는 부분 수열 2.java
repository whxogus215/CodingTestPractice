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
        
        List<Integer> lis = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if (lis.isEmpty()) {
                lis.add(arr[i]);
                continue;
            } 
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                // 이분 탐색
                int left = 0;
                int right = lis.size() - 1;
                int index = lis.size();
                int target = arr[i];
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if (lis.get(mid) >= target) {
                        index = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (index < i) {
                    lis.set(index, target);
                }
            }
        }
        
        System.out.println(lis.size());
    }
}
