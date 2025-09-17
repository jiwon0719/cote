import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> cache = new LinkedList<>();
        
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            // Cache hit인 경우
            if (cache.contains(lowerCity)) {
                cache.remove(lowerCity);
                cache.addFirst(lowerCity);
                answer += 1;
            } 
            // Cache miss인 경우
            else {
                if (cache.size() == cacheSize) {
                    cache.removeLast();
                }
                cache.addFirst(lowerCity);
                answer += 5;
            }
        }
        
        return answer;
    }
}