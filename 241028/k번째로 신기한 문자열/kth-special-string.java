import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String T = sc.next();
        
        String[] arr = new String[n];
        String[] clone = new String[n];
        int index = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
            if (arr[i].startsWith(T)) {
                clone[index++] = arr[i];
            }
        }

        Arrays.sort(clone, 0, index);

        System.out.println(clone[k - 1]);
    }
}