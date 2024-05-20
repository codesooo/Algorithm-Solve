import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            String now = s.substring(i,i+1);
            if(stack.size() != 0 && stack.peek().equals(now)){
                stack.pop();
            } else{
                stack.push(now);
            }
        if(stack.size() == 0){
            answer = 1;
        } else{
            answer = 0;
        }
            
        }

        return answer;
    }
}