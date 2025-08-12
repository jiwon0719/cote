import java.io.*;
import java.util.*;

public class b_10825_국영수 {
    public static class Person implements Comparable<Person> {
        String name;
        int ko;
        int eng;
        int math;

        public Person(String name, int ko, int eng, int math) {
            this.name = name;
            this.ko = ko;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Person o) {
            if(this.ko == o.ko) {
                if(this.eng == o.eng) {
                    if(this.math == o.math) {
                        return this.name.compareTo(o.name);
                    } else {
                        return o.math - this.math;
                    }
                } else {
                    return this.eng - o.eng;
                }
            } else {
                return o.ko - this.ko;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Person(name, ko, eng, math));
        }

        Collections.sort(list);

        for(Person p : list) {
            System.out.println(p.name);
        }
    }
}
