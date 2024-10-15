public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            printTenStars();
        }
    }
    public static void printTenStars() {
        for(int i = 0; i < 10; i ++) {
            System.out.print("*");
        }
        System.out.println();
    }
}