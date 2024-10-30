import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            people[i] = new Person(name, height, weight);
        }

        Arrays.sort(people);
        for(int i = 0; i < n; i++) {
            System.out.print(people[i].name + " ");
            System.out.print(people[i].height + " ");
            System.out.print(people[i].weight);
            System.out.println();
        }
    }
}

class Person implements Comparable<Person> {
    String name;
    int height;
    int weight;

    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        if (this.height == person.height) {
            return person.weight - this.weight;
        }
        return this.height - person.height;
    }
}