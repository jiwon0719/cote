import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            ArrayList<Integer> list = new ArrayList<>();

            if(n > 0) {
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for(String num : nums) {
                    list.add(Integer.parseInt(num));
                }
            }

            boolean isError = false;
            boolean isReverse = false;

            for(char ch : func.toCharArray()) {
                if(ch == 'R') {
                    isReverse = !isReverse;
                } else if(ch == 'D') {
                    if(list.size() == 0) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }

                    if(isReverse) {
                        list.remove(list.size() - 1);
                    } else {
                        list.remove(0);
                    }
                }
            }

            if(!isError) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if(list.size() > 0) {
                    if(isReverse) {
                        for(int i = list.size() - 1; i > 0; i--) {
                            sb.append(list.get(i)).append(",");
                        }
                        sb.append(list.get(0));
                    } else {
                        for(int i = 0; i < list.size() - 1; i++) {
                            sb.append(list.get(i)).append(",");
                        }
                        sb.append(list.get(list.size() - 1));
                    }
                }

                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}