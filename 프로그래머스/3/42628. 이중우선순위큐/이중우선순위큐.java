import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String s : operations){
            if(s.equals("D 1")){
                if(!maxPQ.isEmpty()){
                    int max = maxPQ.poll();
                    minPQ.remove(max);
                }
            } else if(s.equals("D -1")){
                if(!maxPQ.isEmpty()){
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            } else{
                int num = Integer.parseInt(s.substring(2));
                maxPQ.offer(num);
                minPQ.offer(num); 
            }
        }
        
        if(maxPQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        
        return answer;
    }
}