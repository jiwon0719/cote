class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1. new_id의 모든 대문자를 대응되는 소문자로 치환합니다. 
        new_id = new_id.toLowerCase();
        
        // 2. new_id에서 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거합니다. 
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        
        // 3. new_id에서 마침표가 2번이상 연속된 부분을 하나의 마침표로 치환합니다. 
        // 전문자랑 비교해서 전이 마침표이고, 현도 마침표이면 전글자 삭제하기. 현이 전이 됨. 
        char pre = new_id.charAt(0);
        int i = 0;
        while(i < new_id.length() - 1) {
            if(new_id.charAt(i) == '.' && new_id.charAt(i + 1) == '.') {
                new_id = new_id.substring(0, i) + new_id.substring(i + 1);
            } else {
                i++;
            }
        }
        
        // 4. new_id에서 마침표가 처음이나 끝에 위치한다면 제거합니다. 
        if(new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        } 
        
        if(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 5. new_id가 빈 문자열이라면, new_id에 'a'를 대입합니다. 
        if(new_id.length() == 0) {
            new_id = "a";
        }
        
        // 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        
        // 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id = new_id + String.valueOf(new_id.charAt(new_id.length() - 1));
            }
        }
        
        return new_id;
    }
}