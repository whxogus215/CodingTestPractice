import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();

        char[] dna = sc.next().toCharArray();

        int aCount = sc.nextInt();
        int cCount = sc.nextInt();
        int gCount = sc.nextInt();
        int tCount = sc.nextInt();

        int result = 0;

        int first = 0, last = P - 1;
        int a = 0, c = 0, g = 0, t = 0;
        for (int i = first; i <= last; i++) {
            if (dna[i] == 'A') {
                a++;
            }
            if (dna[i] == 'C') {
                c++;
            }
            if (dna[i] == 'G') {
                g++;
            }
            if (dna[i] == 'T') {
                t++;
            }
        }
        if (a >= aCount && c >= cCount && g >= gCount && t >= tCount) {
            result++;
        }

        while (last + 1 < dna.length) {
            int next = last + 1;
            if (dna[next] == 'A') {
                a++;
            }
            if (dna[next] == 'C') {
                c++;
            }
            if (dna[next] == 'G') {
                g++;
            }
            if (dna[next] == 'T') {
                t++;
            }

            if (dna[first] == 'A') {
                a--;
            }
            if (dna[first] == 'C') {
                c--;
            }
            if (dna[first] == 'G') {
                g--;
            }
            if (dna[first] == 'T') {
                t--;
            }
            first++; last++;
            if (a >= aCount && c >= cCount && g >= gCount && t >= tCount) {
                result++;
            }
        }

        System.out.println(result);
    }
}
