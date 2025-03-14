import java.util.*;

public class Main {
    
    public static int MAX_N = 40;
    public static int N = 15;
    public static int[] arr = new int[N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 15개 중 4개의 순열을 만든다.
        for(int a = 1; a <= MAX_N; a++) {
            for(int b = 1; b <= MAX_N; b++) {
                for(int c = 1; c <= MAX_N; c++) {
                    for(int d = 1; d < MAX_N; d++) {
                        int A = a;
                        int B = b;
                        int C = c;
                        int D = d;

                        int[] result = new int[] {
                            A, B, C, D,
                            A + B, B + C, C + D, D + A, A + C, B + D,
                            A + B + C, A + B + D, A + C + D, B + C + D,
                            A + B + C + D
                        };
                        
                        Arrays.sort(result);
                        Arrays.sort(arr);

                        if (Arrays.equals(result, arr)) {
                            System.out.println(A + " " + B + " " + C + " " + D);
                            return;
                        }
                    }
                }
            }
        }
    }
}