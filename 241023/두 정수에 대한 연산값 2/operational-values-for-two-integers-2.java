import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        IntWrapper wa = new IntWrapper(a);
        IntWrapper wb = new IntWrapper(b);

        modify(wa, wb);

        System.out.println(wa.value + " " + wb.value);
    }

    public static void modify(IntWrapper a, IntWrapper b) {
        if (a.value > b.value) {
            a.value *= 2;
            b.value += 10;
        } else {
            a.value += 10;
            b.value *= 2;
        }
    }
}

class IntWrapper {

    public int value;

    public IntWrapper(int value) {
        this.value = value;
    }
}