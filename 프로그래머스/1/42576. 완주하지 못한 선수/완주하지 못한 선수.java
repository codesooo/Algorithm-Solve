import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String, Integer> h1 = new HashMap<>();
        HashMap<String, Integer> h2 = new HashMap<>();

        Set<String> set = new HashSet<>(Arrays.asList(participant));

        for(String i : set){
            h1.put(i,0);
            h2.put(i,0);
        }
        for(String j : participant){
            h1.replace(j,h1.get(j) + 1);
        }
        for(String k : completion){
            h2.replace(k,h2.get(k) + 1);
        }
        for(String player : set){
            if(h1.get(player) - h2.get(player) == 1){
                answer = player;
            }
        }
        return answer;
    }
}