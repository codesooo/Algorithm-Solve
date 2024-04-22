import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleList = new PriorityQueue<>();
        for(int s : scoville){  // scoville배열 List화하기
            scovilleList.offer(s);
        }
        
        while(scovilleList.peek() < K){
            if(scovilleList.size() == 1){
                return -1;
            }
            int s1 = scovilleList.poll();
            int s2 = scovilleList.poll();
            int new_s = s1 + (s2 * 2);
            
            scovilleList.offer(new_s);
            answer++;

        }
        return answer;
    }
}