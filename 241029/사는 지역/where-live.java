import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            String bungi = sc.next();
            String city = sc.next();
            people[i] = new Person(name, bungi, city);
        }

        int index = 0;
        for(int i = 1; i < n; i++) {
            if (people[i].name.compareTo(people[index].name) > 0) {
                index = i;
                break;
            }
        }

        System.out.println("name " + people[index].name);
        System.out.println("addr " + people[index].bungi);
        System.out.println("city " + people[index].city);
    }
}

class Person {
    String name;
    String bungi;
    String city;

    public Person(String name, String bungi, String city) {
        this.name = name;
        this.bungi = bungi;
        this.city = city;
    }
}