import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] line1 = new int[2];
        int[] line2 = new int[2];
        
        line1[0] = sc.nextInt();
        line1[1] = sc.nextInt();
        line2[0] = sc.nextInt();
        line2[1] = sc.nextInt();

        boolean isIntersect = false;
        for(int i = 0; i < line1.length; i++) {
            if (line1[i] >= line2[0] && line1[i] <= line2[1]) {
                isIntersect = true;
                break;
            }
        }
        for(int i = 0; i < line2.length; i++) {
            if (line2[i] >= line1[0] && line2[i] <= line1[1]) {
                isIntersect = true;
                break;
            }
        }

        if (isIntersect) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }
    }
}