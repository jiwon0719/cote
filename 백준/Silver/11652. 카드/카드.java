import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(maxCount < map.get(num)) maxCount = map.get(num);
        }

        Long answer = Long.MAX_VALUE;
        for(Long key : map.keySet()) {
            if(map.get(key) == maxCount) {
                answer = Math.min(answer, key);
            }
        }

        System.out.println(answer);
    }
}