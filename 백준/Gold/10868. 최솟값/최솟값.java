import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int MAX = Integer.MAX_VALUE;
    private static int[] tree;
    private static int offset;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int length = N;
        int depth = 0;
        while(length != 0) {
            length /= 2;
            depth += 1;
        }
        offset = (int)(Math.pow(2, depth));
        tree = new int[2 * offset];
        Arrays.fill(tree, MAX);
        for(int i = 0; i < N; i++) {
            tree[offset + i] = sc.nextInt();
        }

        initialize();
        
        for(int i = 0; i < M; i++) {
            int start = offset + sc.nextInt() - 1;
            int end = offset + sc.nextInt() - 1;
            getMinNum(start, end);
        }
    }

    private static void initialize() {
        for(int i = tree.length - 1; i > 1; i--) {
            tree[i / 2] = Math.min(tree[i], tree[i / 2]);
        }
    }

    private static void getMinNum(int start, int end) {
        int minResult = MAX;
        while(start <= end) {
            if (start % 2 == 1) {
                minResult = Math.min(minResult, tree[start]);
            }
            if (end % 2 == 0) {
                minResult = Math.min(minResult, tree[end]);
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        System.out.println(minResult);
    }
}
