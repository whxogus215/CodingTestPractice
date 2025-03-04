import java.util.*;

public class Main {
    
    public static int N;
    public static int[] first;
    public static int[] second;
    public static int[] third;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        first = new int[N];
        second = new int[N];
        third = new int[N];

        for(int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
            second[i] = sc.nextInt();
            third[i] = sc.nextInt();
        }

        int maxPoint = 0;
        for(int i = 1; i <= 3; i++) {
            int[] arr = new int[4];
            arr[i] = 1;
            int point = 0;
            for(int j = 0; j < N; j++) {
                change(arr, first[j], second[j]);
                if (arr[third[j]] == 1) {
                    point++;
                }
            }
            maxPoint = Math.max(maxPoint, point);
        }

        System.out.println(maxPoint);
    }

    public static void change(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}