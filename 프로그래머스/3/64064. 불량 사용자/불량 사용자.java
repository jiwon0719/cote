import java.io.*;
import java.util.*;

class Solution {
    
    private Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {     
        List<List<String>> candidates = new ArrayList<>();
        for(String banned : banned_id) {
            List<String> matchedUsers = new ArrayList<>();
            for(String user : user_id) {
                if(isMatched(user, banned)) {
                    matchedUsers.add(user);
                }
            }
            candidates.add(matchedUsers);
        }
        
        backtrack(0, candidates, new HashSet<>());
        
        return resultSet.size();
    }
    
    public boolean isMatched(String user_id, String banned_id) {
        if(user_id.length() != banned_id.length()) return false;
        
        for(int i = 0; i < user_id.length(); i++) {
            char user = user_id.charAt(i);
            char banned = banned_id.charAt(i);
            
            if(banned != '*' && banned != user) return false;
        }
        
        return true;
    }
    
    public void backtrack(int index, List<List<String>> candidates, Set<String> used) {
        if(index == candidates.size()) {
            resultSet.add(new HashSet<>(used));
            return;
        }
        
        for(String candidate : candidates.get(index)) {
            if(!used.contains(candidate)) {
                used.add(candidate);
                backtrack(index + 1, candidates, used);
                used.remove(candidate);
            }
        }
    }
}