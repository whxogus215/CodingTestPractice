import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Data[] datas = new Data[n];

        for(int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            datas[i] = new Data(date, day, weather);
        }

        Data[] filterdDatas = new Data[n];
        int index = 0;
        for(int i = 0; i < n; i++) {
            if (datas[i].weather.equals("Rain")) {
                filterdDatas[index++] = datas[i];
            }
        }

        int fastIndex = 0;
        for(int i = 1; i < index; i++) {
            if (filterdDatas[i].date.compareTo(filterdDatas[fastIndex].date) < 0) {
                fastIndex = i;
            }
        }

        System.out.println(
            filterdDatas[fastIndex].date + " " + filterdDatas[fastIndex].day + " " + filterdDatas[fastIndex].weather);        
    }
}

class Data {
    String date;
    String day;
    String weather;

    public Data(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
}