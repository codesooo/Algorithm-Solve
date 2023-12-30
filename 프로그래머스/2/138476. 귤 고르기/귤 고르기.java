import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> keyArr = new ArrayList<>(map.keySet());
        Collections.sort(keyArr, (o1,o2)->-map.get(o1).compareTo(map.get(o2)));
        
        for(Integer a: keyArr){
            if(map.get(a)>k)    k=0;
            else    k-=map.get(a);
            answer++;
            
            if(k==0)    break;
        }
        
        return answer;
    }
}