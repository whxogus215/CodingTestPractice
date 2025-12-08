import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int BOUND = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        Arrays.fill(arr, BOUND);
        
        int[] lis = new int[N];
        int[] indexLog = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lastIndex = 0;
        lis[lastIndex] = arr[0];
        indexLog[0] = 0;
        
        for(int i = 1; i < N; i++) {
            if (arr[i] > lis[lastIndex]) {
                lis[++lastIndex] = arr[i];
                indexLog[i] = lastIndex;
            } else {
                int low = 0;
                int high = lastIndex;
                while(low <= high) {
                    int mid = low + (high - low) / 2;
                    if (lis[mid] < arr[i]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                lis[low] = arr[i];
                indexLog[i] = low;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int startIndex = lastIndex;
        for(int i = N - 1; i >= 0; i--) {
            if (indexLog[i] == startIndex) {
                startIndex--;
                stack.offerFirst(arr[i]);
            }
        }
        
        System.out.println(lastIndex + 1);
        while(!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }
    }
    
}