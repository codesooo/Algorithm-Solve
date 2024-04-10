import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i,n,visited,computers);
                answer++;
            }
            
        }
        
        return answer;
    }
    public void DFS(int i, int n, boolean[] visited, int[][] computers){
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(i==j){
                continue;
            }
            if(!visited[j] && computers[i][j] == 1){
                DFS(j,n,visited,computers);
            }
        }
    }
}