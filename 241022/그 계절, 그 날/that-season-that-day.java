import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        if (isExist(Y, M, D)) {
            if (M >= 3 && M <= 5) {
                System.out.println("Spring");
            } else if (M >= 6 && M <= 8) {
                System.out.println("Summer");
            } else if (M >= 9 && M <= 11) {
                System.out.println("Fall");
            } else {
                System.out.println("Winter");
            }
        } else {
            System.out.println("-1");
        }
    }

    public static boolean isExist(int Y, int M, int D) {
        // 윤년이면 2월은 29일까지 존재한다.
        if (M <= 12 && D <= getMaxDay(M, isYoon(Y))) {
            return true;
        }
        return false;
    }

    public static boolean isYoon(int Year) {
        // if (Year % 4 == 0 && Year % 100 == 0 && Year % 400 == 0) {
        //     return true;
        // } else if (Year % 4 == 0 && Year % 100 == 0) {
        //     return false;
        // } else if (Year % 4 == 0) {
        //     return true;
        // }
        // return false;
        if (Year % 4 != 0) {
            return false;
        }
        if (Year % 100 != 0) {
            return true;
        }
        if (Year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int getMaxDay(int Month, boolean isYoon) {
        if (Month == 2) {
            if (isYoon) {
                return 29;
            }
            return 28;
        }
        if (Month == 4 || Month == 6 || Month == 9 || Month == 11) {
            return 30;
        }
        return 31;
    }
}