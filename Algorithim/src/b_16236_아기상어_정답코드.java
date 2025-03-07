import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_16236_아기상어_정답코드 {
    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int sharkX, sharkY;
    static int time = 0;

    // 상, 좌, 우, 하 (문제 조건: 상하좌우 이동 가능)
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 맵 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 아기 상어 위치 저장
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 상어가 있던 자리는 빈칸으로
                }
            }
        }

        // 시뮬레이션 시작
        while (true) {
            // 다음 먹을 물고기 찾기
            Fish nextFish = findNextFish();

            // 더 이상 먹을 수 있는 물고기가 없으면 종료
            if (nextFish == null) break;

            // 상어 이동 및 물고기 먹기
            time += nextFish.distance;
            sharkX = nextFish.x;
            sharkY = nextFish.y;
            map[sharkX][sharkY] = 0; // 물고기를 먹었으므로 빈칸으로

            // 먹은 물고기 수 증가 및 상어 크기 증가 여부 확인
            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    // BFS로 다음에 먹을 물고기 찾기
    static Fish findNextFish() {
        PriorityQueue<Fish> candidates = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        Queue<Fish> queue = new LinkedList<>();

        // 초기 상어 위치 추가
        queue.offer(new Fish(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        while (!queue.isEmpty()) {
            Fish current = queue.poll();

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 맵 범위 내이고 방문하지 않았으며 상어가 지나갈 수 있는 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;

                    // 먹을 수 있는 물고기인 경우
                    if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                        candidates.offer(new Fish(nx, ny, current.distance + 1));
                    }

                    // 빈 칸이거나 크기가 같은 물고기가 있는 경우 (지나갈 수만 있음)
                    queue.offer(new Fish(nx, ny, current.distance + 1));
                }
            }
        }

        // 후보 물고기 중 조건에 맞는 물고기 선택
        return candidates.isEmpty() ? null : candidates.poll();
    }

    // 물고기 클래스 (위치, 거리, 비교 기준 구현)
    static class Fish implements Comparable<Fish> {
        int x, y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        // 비교 기준: 거리 → 위쪽 → 왼쪽 순
        @Override
        public int compareTo(Fish o) {
            if (this.distance != o.distance) {
                return this.distance - o.distance;
            }
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
}