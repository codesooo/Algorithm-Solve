import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            list.add((int)Math.ceil((100 -progresses[i]) / (speeds[i] * 1.0)));
        }
        for(int j=0; j<list.size(); j++){
            if(stack.size() == 0 || stack.get(0) >= list.get(j)){
                stack.add(list.get(j));
            }
            else{
                answer.add(stack.size());
                stack.clear();
                stack.add(list.get(j));
            }
            if(j == list.size()-1){
                answer.add(stack.size());
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}