    import java.util.*;

    /**
     * M개의 우주, N개의 행성
     * 균등한 우주의 쌍은 몇개인가?
     *
     * 주의) 두 우주가 "균등"하다는 것은 행성들의 크기 관계(크다, 작다, 같다)가 동일하다는 의미
     * 주의)  구성이 같은데 순서만 다른 우주의 쌍은 한 번만 센다.
     * -> 순열이 아닌 조합의 개수를 세라는 의미
     */
    public class b_18869_멀티버스2_이분탐색 {

        static int M, N;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            M = sc.nextInt(); // 우주의 개수
            N = sc.nextInt(); // 행성의 개수
            int [][] universes = new int[M][N]; // 우주별 행성의 무게를 이차원 배열에 저장

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    universes[i][j] = sc.nextInt();
                }
            }

            System.out.println(solution(M, N, universes));
        }

        private static int solution(int M, int N, int[][] universes) {
            // 패턴 Map에 저장하기
            Map<String, Integer> map = new HashMap<>();
            for(int[] universe : universes) {
                String pattern = getPattern(universe);
                map.put(pattern, map.getOrDefault(pattern, 0) + 1); // 키가 존재하면 값 반환, 없으면 0 반환
            }

            // 조합 개수 찾기
            int result = 0;
            for(int count : map.values()) {
                result += count * (count - 1) / 2;
            }

            return result;
        }

        private static String getPattern(int[] universe) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < N-1; i++) {
                for(int j = i + 1; j < N; j++) {

                    if(universe[i] > universe[j]) sb.append(1);
                    else if (universe[i] < universe[j]) sb.append(2);
                    else sb.append(0);
                }
            }

            return sb.toString();
        }
    }
