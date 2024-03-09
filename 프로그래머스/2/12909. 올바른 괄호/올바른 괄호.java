import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        
        for(int i=0; i<sArray.length; i++){
            if(stack.size() == 0){
                stack.add(sArray[i]);
            }
            else if(sArray[i] == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }
            }
            else{
                stack.add(sArray[i]);
            }
        }
        if(stack.size() == 0) {
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}