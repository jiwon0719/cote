class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        if(included[0]) answer = a;
        int num = a;
        
        for(int i = 1; i < included.length; i++) {
            num += d;
            if(included[i]) {
                answer += num; 
            }
        }
        
        return answer;
    }
}