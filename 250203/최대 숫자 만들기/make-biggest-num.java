import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(String.valueOf(arr[i]));
        }

        System.out.println(sb.toString());
    }
}