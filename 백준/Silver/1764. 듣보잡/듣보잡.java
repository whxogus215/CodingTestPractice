import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String listener = sc.next();
            set.add(listener);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String viewer = sc.next();
            if (set.contains(viewer)) {
                list.add(viewer);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
