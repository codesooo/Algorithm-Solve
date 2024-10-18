import java.util.*;
class Solution {
    static int cross = 0;
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        // 다중 집합 만들기
        makeSet(str1, str1List);
        System.out.println("=========");
        makeSet(str2, str2List);
        // 교집합 찾기 (원소 비교해서 같은 것 찾기)
        
        if(str1List.size() > str2List.size()){
            compare(str2List, str1List);
        }
        else{
            compare(str1List, str2List);
        }
        
        
        int union = str1List.size() + str2List.size() - cross;
        System.out.println("cross : " + cross + "union : " + union);
        
        // 합집합 크기 = 두 집합의 크기 - 교집합 크기
        // 둘 다 공집합일 경우?
        
        if(union == 0){
            answer = 65536;
            return answer;
        }
        if(cross == 0){
            return answer;
        }
        
        // 65536 곱하고, 정수부만 출력
        answer = cross * 65536 / union ;
        System.out.println(answer);
        return answer;
        
    }
    
    private void makeSet(String str, List<String> list){
        for(int i=0; i<str.length()-1; i++){
            String now = str.substring(i,i+2);
            char c1 = now.charAt(0);
            char c2 = now.charAt(1);
            
            // 문자가 아니면 저장할 수 없음
            if(!Character.isLetter(c1) || !Character.isLetter(c2)){
                continue;
            }
            System.out.println("now : " + now);
            list.add(now);
        }
    }
    
    private void compare(List<String> list1, List<String> list2){
        // for(String s1 : list1){
        for(int i=0; i<list1.size(); i++){
            // for(String s2 : list2){
            for(int j=0; j<list2.size(); j++){
                
                // System.out.println("s1.0 : " +  (s1.charAt(0) - '0') +
                //                    ", s1.1 : " +  (s1.charAt(1) - '0') +
                //                    ", s2.0 : " + (s2.charAt(0) - '0') +
                //                    ", s2.1 : " + (s2.charAt(1) - '0'));
            
                int c1_0 = list1.get(i).charAt(0) - '0';
                int c1_1 = list1.get(i).charAt(1) - '0';
                int c2_0 = list2.get(j).charAt(0) - '0';
                int c2_1 = list2.get(j).charAt(1) - '0';
                
                int sub1 = Math.abs(c1_0 - c2_0);
                int sub2 = Math.abs(c1_1 - c2_1);
                
                if((sub1 == 32 || sub1 == 0) 
                   && (sub2 == 32 || sub2 == 0))  {
                    cross++;
                    list2.set(j, "  ");
                    break;
                }
            }
        }
    }
}