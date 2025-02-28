import java.util.*;

public class b_17141_연구소2_bfs {

    static int N, M;
    static int[][] map;
    static int minTime = Integer.MAX_VALUE;
    static int NotAllSpreadVirus = 0;
    static int combinationCnt = 0;
    static List<int[]> emptyCells = new ArrayList<>();
    static List<int[]> virusAbleCells = new ArrayList<>();
    static List<int[]> virusCells = new ArrayList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //연구소의 크기
        map = new int[N][N];
        M = sc.nextInt(); // 놓을 수 있는 바이러스 개수

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();

                if(map[r][c] == 0) {
                    emptyCells.add(new int[]{r, c});
                } else if(map[r][c] == 2) {
                    virusAbleCells.add(new int[]{r, c});
                }
            }
        }

        // 바이러스 놓을 수 있는 조합 찾기(백트래킹)
        putVirus(0, 0);

        // 만약 모든 조합에서 전염이 안된다면 -1 출력
        if(combinationCnt == NotAllSpreadVirus) {
            System.out.println(-1);
            return;
        }
        System.out.println(minTime);
    }

    public static void putVirus(int start, int count) {
        // 바이러스 M개 선택 다 했다면, 전염 시작
        if(count == M) {
            combinationCnt++;
            spreadVirus();
            return;
        }

        // 바이러스 위치 조합
        for(int i = start; i < virusAbleCells.size(); i++) {
            int[] virus = virusAbleCells.get(i);
            int r = virus[0];
            int c = virus[1];

            map[r][c] = 99999; // 바이러스 놓기
            virusCells.add(new int[] {r, c});

            putVirus(i+1, count+1);

            map[r][c] = 2;
            virusCells.remove(virusCells.size() -1);
        }
    }


    public static void spreadVirus() {
        // 지도 깊은 복사
        int[][] tmpMap = new int[N][N];
        for(int r = 0; r < N; r++) {
            tmpMap[r] = map[r].clone();
        }

        // 기존에 2였던 곳들은 0(빈칸)으로 변경하기
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(tmpMap[r][c] == 2) {
                    tmpMap[r][c] = 0;
                }
            }
        }

        // 벽은 -1로 변경하기
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(tmpMap[r][c] == 1) {
                    tmpMap[r][c] = -1;
                }
            }
        }

        // 바이러스는 -2로 변경하기
        for(int[] virus : virusCells) {
            tmpMap[virus[0]][virus[1]] = -2;
        }

        // 전염(BFS)
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < virusCells.size(); i++) {
            int[] virus = virusCells.get(i);
            queue.offer(new int[]{virus[0], virus[1], 0});
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curR = curr[0];
            int curC = curr[1];
            int time = curr[2];

            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || tmpMap[nr][nc] != 0) continue;

                tmpMap[nr][nc] = time + 1;
                queue.offer(new int[]{nr, nc, time + 1});

            }
        }

        // 모두 전염되었는지 확인하고 최대 시간 계산
        int maxTime = 0;
        boolean allSpread = true;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(tmpMap[r][c] == 0) { // 바이러스가 퍼지지 않은 빈 칸이 있음
                    allSpread = false;
                    break;
                }
                if(tmpMap[r][c] > 0) { // 바이러스가 퍼진 곳의 최대 시간 계산
                    maxTime = Math.max(maxTime, tmpMap[r][c]);
                }
            }
            if(!allSpread) break;
        }

        // 모든 빈 칸에 바이러스가 퍼졌다면 최소 시간 갱신
        if(allSpread) {
            minTime = Math.min(minTime, maxTime);
        } else {
            NotAllSpreadVirus++;
        }
    }
}
