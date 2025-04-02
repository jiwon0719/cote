import java.io.*;
import java.util.*;

public class b_9017_크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            int[] TeamMemberCnt = new int[N+1];
            for(int i = 0; i < N; i++) {
                TeamMemberCnt[input[i]]++;
            }

            Map<Integer, Integer> map = new HashMap<>(); // 키 : 팀번호, 값 : 0
            for(int i = 0; i <= N; i++) {
                if(TeamMemberCnt[i] == 6) {
                    map.put(i, 0);
                }
            }

            int[] ranks = new int[N]; // 등수 저장
            int rank = 1;
            for(int i = 0; i < N; i++) {
                if(map.containsKey(input[i])) {
                    ranks[i] = rank++;
                }
            }

//            System.out.println(Arrays.toString(ranks));

            // 팀별 멤버 등수 저장해놓기
            Map<Integer, ArrayList<Integer>> teamMember = new HashMap<>();
            for(int i = 0; i < N; i++) {
                int team = input[i];
                if(!map.containsKey(team)) continue;
                if(!teamMember.containsKey(team)) {
                    teamMember.put(team, new ArrayList<>());
                }

                if(ranks[i] > 0) {
                    teamMember.get(team).add(ranks[i]);
                }
            }

            // 팀별 누적 점수 계산(상위 4명)
            for(int team : map.keySet()) {
                int score = 0;
                ArrayList<Integer> members = teamMember.get(team);

                for(int i = 0; i < 4; i++) {
                    score += members.get(i);
                }

                map.put(team, score);
            }

            // 우승팀 계산
            int winner = -1;
            int minScore = Integer.MAX_VALUE;

            for(int team : map.keySet()) {
                int score = map.get(team);

                if(score < minScore) {
                    minScore = score;
                    winner = team;
                } else if(score == minScore) { // 동점팀 만나면
                    ArrayList<Integer> currTeamMembers = teamMember.get(team);
                    ArrayList<Integer> winnerTeamMembers = teamMember.get(winner);

                    if(currTeamMembers.get(4) < winnerTeamMembers.get(4)) {
                        winner = team;
                    }
                }
            }

            System.out.println(winner);

        }
    }
}
