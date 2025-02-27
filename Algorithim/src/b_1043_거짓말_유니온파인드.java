import java.util.ArrayList;
import java.util.Scanner;

public class b_1043_거짓말_유니온파인드 {

    static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람의 수
        int M = sc.nextInt(); // 파티의 수

        // 사람 수 만큼 parents[] 배열 만들기
        // 초기상태 부모는 자기 자신
        parents = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parents[i]  = i;
        }

        // 진실을 알고 있는 사람 집합 만들기(union)
        int truthCnt = sc.nextInt();
                // 만약 진실을 알고 있는 사람이 아무도 없다면, 모든 파티에서 거짓말 가능
                if(truthCnt == 0) {
                    System.out.println(M);
                    return;
                }
        int truthParent = sc.nextInt();
        for(int i = 1; i < truthCnt; i++) {
            union(truthParent, sc.nextInt());
        }

        // 파티 정보 저장 및
        // 같은 파티에 있는 사람들 하나의 그룹으로 만들기
        ArrayList<Integer>[] parties = new ArrayList[M]; // 맞는지 모르겠네
        for(int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int partySize = sc.nextInt();

            if(partySize > 0) {
                int firstPerson = sc.nextInt();
                parties[i].add(firstPerson);

                for(int j = 1; j < partySize; j++) {
                    int person = sc.nextInt();
                    parties[i].add(person);
                    union(firstPerson, person);
                }
            }
        }

        // 서로소 집합 개수 찾기
        int ans = 0;
        for(int i = 0; i < M; i++) {
            boolean canLie = true; // 우선 거짓말 가능하다고 가정하고

            for(int person : parties[i]) { // 파티의 사람들을 돌아보면서
                if(find(person) == find(truthParent)) { // 만약 진실을 아는 사람과 같은 그룹이라면
                    canLie = false;
                    break;
                }
            }

            if(canLie) ans++;
        }

        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}