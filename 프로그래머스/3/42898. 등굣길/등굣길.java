class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 0;
        dp[2][1] = 1;
        dp[1][2] = 1;
        
        // 우물인 곳 -1 처리
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j] == -1){
                    continue;
                }
                if(dp[i][j-1] == -1 || dp[i-1][j] == -1){
                    dp[i][j] = Math.max(Math.max(dp[i][j-1], dp[i-1][j]), 
                                        dp[i][j]) % 1000000007;
                }
                dp[i][j] = Math.max(dp[i][j-1] + dp[i-1][j], dp[i][j])
                    % 1000000007;
            }
        }
        
        answer = dp[n][m] % 1000000007;
        return answer;
    }
}