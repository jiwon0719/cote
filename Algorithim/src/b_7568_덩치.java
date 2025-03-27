import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_7568_덩치 {

    public static class Person {
        int w;
        int h;
        int rank;

        public Person(int weight, int height, int rank) {
            this.w = weight;
            this.h = height;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i] = new Person(weight, height, 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (people[i].w < people[j].w && people[i].h < people[j].h) {
                    people[i].rank++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(people[i].rank + " ");
        }
    }
}