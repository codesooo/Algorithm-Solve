import java.util.*;
class Solution {
    public int solution(String[][] clothes) { 
        Map<String, Integer> type = new HashMap<>();
        int count = 1;
        for(int i=0; i< clothes.length; i++){
            type.put(clothes[i][1], 0);
        }
        for(int j=0; j<clothes.length; j++){
            for(String t : type.keySet()) {
                if(t.equals(clothes[j][1])){
                    type.replace(t, type.get(t)+1);
                }
            }
        }
        for(String t : type.keySet()){
            count *= (type.get(t)+1);
        }
        return count-1;
    }
}