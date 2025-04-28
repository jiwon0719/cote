class Solution {
    public String[] solution(String my_string) {
        String[] str = my_string.split(" ");
        
        int size = 0;
        for(int i = 0; i < str.length; i++) {
            if(!str[i].equals("")) {
                size++;
            }
        }
        
        String[] answer = new String[size];
        
        int idx = 0;
        for(int i = 0; i < str.length; i++) {
            if(!str[i].equals("")) {
                answer[idx] = str[i];
                idx++;
            }
        }
        
        return answer;
    }
}