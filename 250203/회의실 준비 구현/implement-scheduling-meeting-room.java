import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Time> times = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            times.add(new Time(s, e));
        }

        // end를 기준으로 오름차순 정렬하기!
        Collections.sort(times, (t1, t2) -> t1.end - t2.end);

        int max = 0;
        int beforeEnd = -1;

        for (Time time : times) {
            if (beforeEnd > time.start) {
                continue;
            }
            beforeEnd = time.end;
            max++;
        }

        System.out.println(max);
    }

    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}