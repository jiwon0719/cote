class Solution {
    public String solution(int[] numLog) {
        int n = numLog[0];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < numLog.length; i++) {
            int result = numLog[i] - n;
            
            if(result == 1) sb.append("w");
            else if(result == -1) sb.append("s");
            else if(result == 10) sb.append("d");
            else sb.append("a");
            
            n = numLog[i];
        }
        
        return sb.toString();
    }
}