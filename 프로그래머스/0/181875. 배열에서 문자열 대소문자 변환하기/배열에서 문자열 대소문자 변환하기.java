class Solution {
    public String[] solution(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
        
            if(i % 2 != 0) { // 홀수
                strArr[i] = strArr[i].toUpperCase();
            } else {
                strArr[i] = strArr[i].toLowerCase();
            }
        }
            
        return strArr;
        
    }
}