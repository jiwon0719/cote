class Solution {
    public String solution(String my_string, String alp) {
        String a = alp.toUpperCase();
        
        return my_string.replaceAll(alp, a);
    
    
    }
}