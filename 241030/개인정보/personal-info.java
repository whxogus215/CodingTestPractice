import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] people = new Person[5];
        for(int i = 0; i < 5; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();

            people[i] = new Person(name, height, weight);
        }

        Arrays.sort(people, (a, b) -> (a.name.compareTo(b.name)));
        System.out.println("name");
        for(int i = 0; i < 5; i++) {
            System.out.print(people[i].name + " ");
            System.out.print(people[i].height + " ");
            System.out.printf("%.1f", people[i].weight);
            System.out.println();
        }

        Arrays.sort(people, (a, b) -> b.height - a.height);
        System.out.println("\nheight");
        for(int i = 0; i < 5; i++) {
            System.out.print(people[i].name + " ");
            System.out.print(people[i].height + " ");
            System.out.printf("%.1f", people[i].weight);
            System.out.println();
        }
    }
}

class Person {
    String name;
    int height;
    double weight;

    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}