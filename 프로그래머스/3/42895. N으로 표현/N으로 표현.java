import java.util.*;
class Solution {
    // static char[] operations = {'5', '+', '-', '*', '/'};
    public int solution(int N, int number) {
//         int answer = 0;
//         if(N == number){
//             answer = 1;
//             return answer;
//         }
        
//         for(int i=1; i<=4; i++){
//             List<List<Character>> result = new ArrayList<>();
//             combinations(i, new ArrayList<>(), result);
//             if(getNum(N, i, result) == number){
//                 answer = i;
//                 return answer;
//             }
//         }
        
//         answer = -1;
//         return answer;
//     }
    
//     private void combinations(int cnt, List<Character> current, List<List<Character>> result){
//         if(current.size() == cnt){
//             result.add(new ArrayList<>(current));
//             // if(cnt<4){
//             //     System.out.println(Arrays.asList(current));
//             // }
//             return;
//         }
        
//         for(int i=0; i<operations.length; i++){
//             current.add(operations[i]);
//             combinations(cnt, current, result);
//             current.remove(current.size()-1);
//         }
//     }
    
//     private int getNum(int N, int cnt, List<List<Character>> result){
//         int res = 0;
//         for(int i=0; i<result.size(); i++){
//             res = N;
//             for(int j=0; j<cnt; j++){
//                 if()
//                 switch(result.get(i).get(j)){
//                     case '+':
//                         res += N;
//                         System.out.println("+" + res);
//                         break;
//                     case '-':
//                         res -= N;
//                         System.out.println("-" + res);
//                         break;
//                     case '*':
//                         res *= N;
//                         System.out.println("*" + res);
//                         break;
//                     case '/':
//                         res /= N;
//                         System.out.println("/" +res);
//                         break;                        
//                 }
//             }
//         }
//         // System.out.println(res);
//         return res;
         if (N == number) {
            return 1;
        }
        
        // N을 i번 사용해서 만들 수 있는 숫자들을 저장하는 리스트
        List<Set<Integer>> dp = new ArrayList<>();
        
        // i = 0 은 비어있는 상태로 유지 (0번 사용은 없으므로)
        dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> currentSet = new HashSet<>();
            
            // N을 i번 반복한 숫자 (ex: N=5일 때 5, 55, 555 등)
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeatedN);
            
            // N을 j번 사용한 결과와 N을 i-j번 사용한 결과를 사칙연산으로 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        currentSet.add(a + b);
                        currentSet.add(a - b);
                        currentSet.add(a * b);
                        if (b != 0) {
                            currentSet.add(a / b);
                        }
                    }
                }
            }
            
            // 만약 목표 숫자가 있다면 반환
            if (currentSet.contains(number)) {
                return i;
            }
            
            // dp 리스트에 추가
            dp.add(currentSet);
        }
        
        // 8번을 넘으면 -1 반환
        return -1;
    }
}