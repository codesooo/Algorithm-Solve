import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> priorQueue = new LinkedList<>();
        Queue<Integer> locQueue = new LinkedList<>();

        List<Integer> process_prior = new LinkedList<>();
        List<Integer> process_loc = new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            priorQueue.add(priorities[i]);
            locQueue.add(i);
        }

        while(priorQueue.size()>0){
            if(priorQueue.peek() >= Collections.max(priorQueue)){
                process_prior.add(priorQueue.poll());
                process_loc.add(locQueue.poll());
            }
            else{
                priorQueue.add(priorQueue.peek());
                priorQueue.remove(priorQueue.peek());
                locQueue.add(locQueue.peek());
                locQueue.remove(locQueue.peek());
            }
        }

        int c = 1;
        for(int i=0; i<process_loc.size(); i++){
            if(process_loc.get(i) == location){
                answer = c;
            }
            c++;
        }
        
        return answer;
    }
}