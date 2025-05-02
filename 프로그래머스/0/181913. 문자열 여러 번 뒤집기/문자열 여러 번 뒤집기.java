class Solution {
    public String solution(String my_string, int[][] queries) {
        
        StringBuilder sb = new StringBuilder(my_string);
        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            
            String subStr = sb.substring(s, e + 1);
            StringBuilder reverseSubStr = new StringBuilder(subStr).reverse();
            sb.replace(s, e + 1, reverseSubStr.toString());
            
        }
        
        return sb.toString();
    }
}