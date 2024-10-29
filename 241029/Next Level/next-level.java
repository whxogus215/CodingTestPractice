import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();

        Player p1 = new Player();
        Player p2 = new Player(id, level);

        System.out.println("user " + p1.id + " lv " + p1.level);
        System.out.println("user " + p2.id + " lv " + p2.level);
    }
}

class Player {
    String id;
    int level;

    public Player() {
        this.id = "codetree";
        this.level = 10;
    }

    public Player(String id, int level) {
        this.id = id;
        this.level = level;
    }
}