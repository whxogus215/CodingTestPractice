import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agent[] agents = new Agent[5];
        int min = 101;
        int index = 0;
        for(int i = 0; i < 5; i++) {
            char code = sc.next().charAt(0);
            int score = sc.nextInt();
            agents[i] = new Agent(code, score);
            if (score < min) {
                index = i;
                min = score;
            }
        }

        System.out.println(agents[index].code + " " + agents[index].score);
    }
}

class Agent {
    char code;
    int score;

    public Agent(char code, int score) {
        this.code = code;
        this.score = score;
    }
}