import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Student[] students = new Student[N];

        for(int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            students[i] = new Student(i + 1, h, w);
        }
        
        Arrays.sort(students);

        for(int i = 0; i < N; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].number);
        }
    }
}

class Student implements Comparable<Student> {
    int number;
    int height;
    int weight;

    public Student(int number, int height, int weight) {
        this.number = number;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student student) {
        if (this.height == student.height) {
            if (this.weight == student.weight) {
                return this.number - student.number;
            }
            return student.weight - this.weight;   
        }
        return student.height - this.height;
    }
}