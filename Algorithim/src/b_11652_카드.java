import java.io.*;
        import java.util.*;

public class b_11652_카드 {
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

        List<Long> list = new ArrayList<>();
        for(Long key : map.keySet()) {
            if(map.get(key) == maxCount) list.add(key);
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}