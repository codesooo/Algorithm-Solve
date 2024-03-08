import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> stack = new ArrayList<>();
        stack.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            if(arr[i] != stack.get(stack.size()-1))
            {stack.add(arr[i]);}
        }
        return stack.stream().mapToInt(i->i).toArray();
            
            
               
    }
}