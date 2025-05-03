class Solution {
    public String solution(String myString, String pat) {
        int lastIndex = myString.lastIndexOf(pat); // 마지막으로 등장하는 pat의 시작인덱스 반환
        
        return myString.substring(0, lastIndex + pat.length());
    }
}