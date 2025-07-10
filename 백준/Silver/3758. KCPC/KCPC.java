import java.io.*;
import java.util.*;

public class Main {
     static class Team {
        int id;
        Map<Integer, Integer> scores;
        int totalScore;
        int submissionCount;
        int lastSubmissionTime;

        public Team(int id) {
            this.id = id;
            this.scores = new HashMap<>();
            this.totalScore = 0;
            this.submissionCount = 0;
            this.lastSubmissionTime = 0;
        }

        public void addSubmission(int problemId, int score, int time) {
            submissionCount++;
            lastSubmissionTime = time;

            if(!scores.containsKey(problemId) || scores.get(problemId) < score) {
                int oldScore = scores.getOrDefault(problemId, 0);
                scores.put(problemId, score);
                totalScore = totalScore -oldScore +  score;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             int N = Integer.parseInt(st.nextToken());
             int K = Integer.parseInt(st.nextToken());
             int T = Integer.parseInt(st.nextToken());
             int M = Integer.parseInt(st.nextToken());

             Map<Integer, Team> teams = new HashMap<>();
             for(int time = 0; time < M; time++) {
                st = new StringTokenizer(br.readLine());
                int teamId =  Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(!teams.containsKey(teamId)) {
                    teams.put(teamId, new Team(teamId));
                }

                teams.get(teamId).addSubmission(problemId, score, time);
             }

             Team myTeam = teams.get(T);
             int rank = 1;
             for(Team team : teams.values()) {
                 if (isHighRank(team, myTeam)) rank++;
             }

             System.out.println(rank);
        }
    }

    public static boolean isHighRank(Team team1, Team team2) {
        // 최종 점수 높을수록
        if(team1.totalScore != team2.totalScore) {
            return team1.totalScore > team2.totalScore;
        }
        // 제출 횟수 적을수록
        if(team1.submissionCount != team2.submissionCount) {
            return team1.submissionCount < team2.submissionCount;
        }
        // 마지막 제출 빠를수록(숫자가 작을수록)
        return  team1.lastSubmissionTime < team2.lastSubmissionTime;
    }
}
