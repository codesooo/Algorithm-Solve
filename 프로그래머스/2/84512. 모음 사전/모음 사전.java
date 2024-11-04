import java.util.*;
class Solution {
    private static final char[] Characters = {'A', 'E', 'I', 'O', 'U'};
    private static List<String> wordList = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        makeWords("");
        
        answer = wordList.indexOf(word);
        return answer;
    }
    
    private void makeWords(String word){
        wordList.add(word);
        if (word.length() == 5){
            return;
        }
        
        for(char c : Characters){
            makeWords(word+c);
        }
    }
}