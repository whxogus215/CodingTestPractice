import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] indexLog = new int[N];
        
        int[] lis = new int[N];
        int lastIndex = 0;
        lis[lastIndex] = arr[0];
        indexLog[0] = 0;

        for(int i = 1; i < N; i++) {
            if (lis[lastIndex] < arr[i]) {
                lis[++lastIndex] = arr[i];
                indexLog[i] = lastIndex;
            } else {
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
                indexLog[i] = index;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int startIndex = lastIndex;
        for(int i = N - 1; i >= 0; i--) {
            if (startIndex < 0) {
                break;
            }
            if (indexLog[i] == startIndex) {
                stack.offerFirst(arr[i]);
                startIndex--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst() + " ");
        }

        System.out.println(lastIndex + 1);
        System.out.println(sb.toString());
    }
}
