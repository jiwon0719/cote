class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        
        int idx = 0;
        for(int i = 0; i < picture.length; i++) {
            String str = picture[i];
            for(int j = 0; j < k; j++) {
                String newStr = "";
                for(int l = 0; l < str.length(); l++) {
                    for(int m = 0; m < k; m++) {
                        newStr += str.charAt(l);
                    }
                }
                answer[idx++] = newStr;
            }
        }
        
        return answer;
    }
}