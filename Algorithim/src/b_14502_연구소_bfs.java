import java.util.*;

public class b_14502_연구소_bfs {

    static int N, M;
    static int[][] map;
    static int maxSafeArea = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> emptyCells = new ArrayList<>();
    static ArrayList<int[]> virusCells = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로(행)
        M = sc.nextInt(); // 가로(열)
        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();

                if(map[r][c] == 0) {
                    emptyCells.add(new int[]{r, c});
                }
                else if(map[r][c] == 2) {
                    virusCells.add(new int[]{r, c});
                }
            }
        }

        // 벽 세우기(조합, 백트래킹)
        buildWalls(0, 0);

        // 출력
        System.out.println(maxSafeArea);
    }

    public static void buildWalls(int start, int count) {
        // 벽 3개 세운 후, 바이러스 감염
        if(count == 3) {
            spreadVirus();
            return;
        }

        // 벽 3개 세우기 조합(+백트래킹)
        for(int i = start; i < emptyCells.size(); i++) {
            int[] emptyCell = emptyCells.get(i);
            int r = emptyCell[0];
            int c = emptyCell[1];

            map[r][c] = 1;

            buildWalls(i + 1, count + 1);

            map[r][c] = 0;
        }
    }

    public static void spreadVirus() {
        // 지도 깊은 복사
        int[][] tmpMap = new int[N][M];
        for(int r = 0; r < N; r++) {
            tmpMap[r] = map[r].clone();
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < virusCells.size(); i++) {
            int[] virus = virusCells.get(i);
            queue.offer(new int[] {virus[0], virus[1]});
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curR = curr[0];
            int curC = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || tmpMap[nr][nc] != 0) continue;

                tmpMap[nr][nc] = 2;
                queue.add(new int[]{nr, nc});
            }
        }

        // 안전영역 계산
        int safeArea = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(tmpMap[r][c] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(safeArea, maxSafeArea);
    }
}
