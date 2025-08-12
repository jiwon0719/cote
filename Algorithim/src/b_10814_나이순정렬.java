import java.io.*;
import java.util.*;

public class b_10814_나이순정렬 {
    public static class Person implements Comparable<Person> {
        int old;
        String name;

        public Person(int old, String name) {
            this.old = old;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.old - o.old;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int old = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(old, name));
        }

        Collections.sort(list);

        for(Person p : list) {
            System.out.println(p.old + " " + p.name);
        }
    }
}
