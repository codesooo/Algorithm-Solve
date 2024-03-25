class Solution {
    static int cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers, target, 0, 0);
        answer = cnt;
        return answer;
    }
    public void DFS(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(sum == target){
                cnt++;
            }
            return;
        }
        
        DFS(numbers, target, depth+1, sum + numbers[depth]);
        DFS(numbers, target, depth+1, sum - numbers[depth]);
    }
}