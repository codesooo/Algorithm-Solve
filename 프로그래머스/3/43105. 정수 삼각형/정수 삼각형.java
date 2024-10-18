class Solution {
    public int solution(int[][] triangle) {
        int r = triangle.length;
        int c = triangle[r-1].length;
        int answer = 0;
        int[][] dp = new int[r][c];
        dp[0][0] = triangle[0][0];
        int[] dx = {-1,-1};
        int[] dy = {-1,0};
        
        for(int i=1; i<r; i++){
            for(int j=0; j<triangle[i].length; j++){
                int max = 0;
                for(int p=0; p<2; p++){
                    int x = i + dx[p];
                    int y = j + dy[p];
                    if(x<0 || y<0 || y>=triangle[x].length){
                        continue;
                    }
                    max = Math.max(dp[x][y], max);
                    
                }
                dp[i][j] = max + triangle[i][j];
            }
        }
        
        for(int i=0; i<c; i++){
            answer = Math.max(dp[r-1][i], answer);
        }
        
        
        return answer;
    }
}