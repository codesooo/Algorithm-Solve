class Solution {
    static int[] arr;
    static int goal;
    static int answer=0;
    public int solution(int[] numbers, int target) {
        arr = numbers;
        goal = target;
        dfs(0,0);
        
        return answer;
    }
    public static void dfs(int index, int sum){
        if(index == arr.length){
            if(sum == goal){
                answer++;
            }
            return;
        }
        
        dfs(index+1, sum + arr[index]);
        dfs(index+1, sum - arr[index]);
        
    }
    
}