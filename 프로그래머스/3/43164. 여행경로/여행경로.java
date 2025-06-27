import java.io.*;
import java.util.*;

class Solution {
    private List<String> result = new ArrayList<>();
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        // 티켓 미리 정렬
        Arrays.sort(tickets, (a, b) -> {
           if(a[0].equals(b[0])) {
               return a[1].compareTo(b[1]);
           } 
            return a[0].compareTo(b[0]);
        });
        
        // 초기화
        visited = new boolean[tickets.length];
        result.add("ICN");
        
        // dfs
        dfs("ICN", tickets, 0);
        
        // 출력
        return result.toArray(new String[0]);
    }
    
    private boolean dfs(String current, String[][] tickets, int dept) {
        // 모든 항공권 선택 시 경로 완성
        if(dept == tickets.length) {
            return true;
        }
        
        // 현재 공항에서 갈 수 있는 티켓 찾기
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                result.add(tickets[i][1]); 
                
                // 다음 경로 찾기
                if(dfs(tickets[i][1], tickets, dept + 1)) {
                    return true;
                }
                
                // 백트래킹 : 실패했으면 되돌리기
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
        
        // 현재 경로로는 모든 티켓을 사용할 수 없음
        return false;
    }
}