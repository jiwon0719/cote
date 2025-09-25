import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>(); // id, nickname
        String[][] logs = new String[records.length][2]; // id, action
        
        // records 파싱하기
        for(int i = 0; i < records.length; i++) {
            String rocord = records[i];
            String[] recordSplit = rocord.split(" ");
            String action = recordSplit[0];
            
            if(action.equals("Enter")) {
                // id가 없으면 > 새로운 인원
                // id가 있으면 > 닉네임 변경
                String id = recordSplit[1];
                String nickname = recordSplit[2];
                map.put(id, nickname);
                
                logs[i][0] = id;
                logs[i][1] = action;
                    
            } else if(action.equals("Leave")) {
                String id = recordSplit[1];
                
                logs[i][0] = id;
                logs[i][1] = action;
                
            } else if(action.equals("Change")) {
                String id = recordSplit[1];
                String nickname = recordSplit[2];
                
                map.put(id, nickname);
            }
        }
        
        // log 출력
        List<String> list = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {
            if(logs[i][0] == null) continue;
            
            String[] log = logs[i];
            String id = log[0];
            String action = log[1];
            String nickname = map.get(id);
                
            if(action.equals("Enter")) {
                list.add(nickname + "님이 들어왔습니다.");
            } else if(action.equals("Leave")) {
                list.add(nickname + "님이 나갔습니다.");   
            }
        }
        
        int size = list.size();
        String[] answer = new String[size];
        int idx = 0;
        for(String s : list) {
            answer[idx++] = s;
        }
        
        return answer;
    }
}