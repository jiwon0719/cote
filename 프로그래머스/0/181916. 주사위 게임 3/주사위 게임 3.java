import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        ArrayList<Integer> four = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
    
        // 같은 숫자가 몇개씩 나왔는지 세기
        int[] dices = {a, b, c, d};
        int[] nums = new int[7]; 
        for(int dice : dices) {
            nums[dice]++;
        }
        
        for(int i = 1; i <= 6; i++) {
            if(nums[i] == 4) four.add(i);
            else if(nums[i] == 3) three.add(i);
            else if(nums[i] == 2) two.add(i);
            else if(nums[i] == 1) one.add(i);
        }
        
        // 경우의 수 계산
        if(!four.isEmpty()) {
            // 네 주사위에거 나온 숫자가 모두 같은 경우 
            int p = four.get(0);
            return 1111 * p;
        } else if(!three.isEmpty()) {
            // 세 주사위에서 나온 숫자가 같은 경우
            // 한개만 다를 것
            int p = three.get(0);
            int q = one.get(0);
            return (10 * p + q) * (10 * p + q);
        } else if(two.size() == 2) {
            // 두 개씩 같은 값이 나온 경우
            int p = two.get(0);
            int q = two.get(1);
            return (p + q) * Math.abs(p - q);
        } else if(two.size() == 1 && one.size() == 2) {
            // 두 개, 한 개, 한 개
            int q = one.get(0);
            int r = one.get(1);
            return q * r;
        } else {
            // 모두 다른 경우
            int min = 10;
            for(int o : one) {
                min = Math.min(min, o);
            }
            return min;
        }
    }
}