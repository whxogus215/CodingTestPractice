import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int[] binary = new int[8];
        int index = 0;
        
        while (line > 0) {
            binary[index++] = line % 10;
            line /= 10;
        }

        int sum = 0;
        for(int i = index - 1; i >= 0; i--) {
            sum = sum * 2 + binary[i];
        }

        System.out.println(sum);        
    }
}