import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimun = getMinimunPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int) (maximum.x - minimun.x + 1);
        int height = (int) (maximum.y - minimun.y + 1);

        // 특정 인덱스에 *을 찍어야 하기 때문에 char형 배열로 선언해야 함!! (중요)
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 좌표 변환 후 * 찍기
        for (Point p : points) {
            int x = (int) (p.x - minimun.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*'; // String은 한번 생성하면 읽기 전용이므로 수정 X -> 특정 인덱스의 문자를 바꾸려면 char형으로 선언해야 됨!!! (중요)
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        return answer;
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 정수인지 판별하는 조건문 수식 : 정수는 1로 나눴을 때 항상 나누어 떨어지는 성질을 이용
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private Point getMinimunPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y); // 왼쪽 아래 좌표 생성
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y); // 오른쪽 위 좌표 생성
    }

    private static class Point {

        public final long x; // 코딩테스트이므로 별도의 getter, setter를 만들지 않도록 public으로 설정해도 됨.
        public final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

}
