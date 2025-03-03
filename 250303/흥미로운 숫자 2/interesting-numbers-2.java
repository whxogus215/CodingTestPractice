import java.util.*;

public class Main {
    
    public static int X, Y;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        Y = sc.nextInt();

        int result = 0;
        for(int num = X; num <= Y; num++) {
            Map<Integer, Integer> map = new HashMap<>();
            updateDigits(num, map);

            if (map.size() == 2) {
                for(Integer key : map.keySet()) {
                    if (map.get(key) == 1) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void updateDigits(int num, Map<Integer, Integer> map) {
        int digit = num % 10;
        map.put(digit, map.getOrDefault(digit, 0) + 1);
        if (num < 10) {
            return ;   
        }
        updateDigits(num / 10, map);
    } 
}