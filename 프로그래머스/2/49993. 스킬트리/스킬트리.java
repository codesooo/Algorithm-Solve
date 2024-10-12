import java.util.*;
class Solution {
    private static char[] tempArr;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillArr = new char[skill.length()];
        for(int i=0; i<skill.length(); i++){
            char ch = skill.charAt(i);
            skillArr[i] = ch;
        }
        
        
        for(String s : skill_trees){
            int[] locationArr = new int[skill.length()];
            Arrays.fill(locationArr, -1);
            tempArr = new char[s.length()];
            for(int i=0; i<s.length(); i++){
                tempArr[i] = s.charAt(i);
            }
            
            for(int i=0; i<skillArr.length; i++){
                for(int j=0; j<tempArr.length; j++){
                    if(tempArr[j] == skillArr[i]){
                        locationArr[i] = j;
                    }
                }
                System.out.print(locationArr[i]);
            }
            System.out.println();
            
            int cnt = 0;
            for(int i=0; i<locationArr.length; i++){
                if(locationArr[i] < 0){
                    cnt++;
                }
            }
            
            if(cnt == locationArr.length){
                answer++;
                System.out.println("cnt_answer : " + answer);
                continue;
            }

            boolean flag1 = true;
            for(int i=1; i<locationArr.length; i++){
                if(locationArr[i] >= 0 && locationArr[i] < locationArr[i-1]){
                    flag1 = false;
                    System.out.println("false1");
                }
                if(locationArr[i] >= 0){
                    if(locationArr[i-1] < 0){
                        flag1 = false;
                        System.out.println("false2");

                    }
                }
            }
            
            if(flag1){
                answer++;
                System.out.println("answer : " + answer);
            }
            
            
        
        }
        
        
        return answer;
    }
}