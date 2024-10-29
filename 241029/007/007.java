import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String place = sc.next();
        int time = sc.nextInt();

        Data data = new Data(code, place, time);

        System.out.println("secret code : " + data.code);
        System.out.println("meeting point : " + data.place);
        System.out.println("time : " + data.time);
    }

    static class Data {
        String code;
        String place;
        int time;

        public Data(String code, String place, int time) {
            this.code = code;
            this.place = place;
            this.time = time;
        }
    }
}