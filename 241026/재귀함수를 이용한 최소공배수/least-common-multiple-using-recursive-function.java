import java.util.*;

public class Main {
    
    public static int MAX_N = 10;
    public static int[] arr = new int[MAX_N];
    public static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(lcs(arr[0], 1));
    }

    public static int lcs(int standard, int index) {
        if (index == n) {
            return standard;
        }

        if (standard > arr[index] && standard % arr[index] == 0) {
            return lcs(standard, index + 1);
        }

        if (arr[index] > standard && arr[index] % standard == 0) {
            return lcs(arr[index], index + 1);
        }
        
        return lcs(standard * arr[index], index + 1);
    }
}