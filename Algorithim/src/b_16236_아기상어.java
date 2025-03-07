import java.util.*;
public class b_16236_아기상어 {

    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;
    static int sharkR, sharkC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();

                if(map[r][c] == 9) {
                    sharkR = r;
                    sharkC = c;
                    map[r][c] = 0; // 상어가 있던 자리는 빈칸으로 만들어야 한다!!!!!!!!!!!!!!!!
                }
            }
        }

        // 시뮬레이션
        while(true) {
            // 다음 먹을 수 있는 물고기를 찾는다.(자신의 크기보다 작은 물고기, 여러마리라면 위쪽, 왼쪽 1마리)
            Fish nextFish = findNextFish();

            // 먹을 수 있는 물고기가 없다면 엄마상어를 호출한다.
            if(nextFish == null) break;

            // 물고리를 먹으러 이동한다. 먹는다.
            time += nextFish.distance;
            sharkR = nextFish.r;
            sharkC = nextFish.c;
            map[sharkR][sharkC] = 0;

            // 상태를 기록하고 상어 크기가 커질 수 있는지 확인한다.
            eatCount++;
            if(eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish findNextFish() {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Queue<Fish> queue = new LinkedList<>();
        boolean[][] isvisited = new boolean[N][N];

        // 처음 상어 위치 큐에 넣기
        queue.offer(new Fish(sharkR, sharkC, 0));
        isvisited[sharkR][sharkC] = true;

        // BFS
        while(!queue.isEmpty()) {
            Fish current = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                // 범위안이고, 상어가 지나갈 수 있는 경우(본인과 크기가 같거나 작은 경우)
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !isvisited[nr][nc] && map[nr][nc] <= sharkSize) {
                    isvisited[nr][nc] = true;
                    queue.add(new Fish(nr, nc, current.distance + 1));

                    // 근데 작아서 먹을 수 있는 경우
                    if(map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                        pq.offer(new Fish(nr, nc, current.distance + 1));
                    }
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }

    static class Fish implements Comparable<Fish> {
        int r, c;
        int distance;

        public Fish(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        // 비교 기준 : 거리 - 위쪽 - 왼쪽
        @Override
        public int compareTo(Fish o) {
            if(this.distance != o.distance) {
                return this.distance - o.distance;
            }
            if(this.r != o.r) {
                return this.r - o.r;
            }
            return this.c - o.c;
        }
    }
}