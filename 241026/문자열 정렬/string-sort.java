import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}