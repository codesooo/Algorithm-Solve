import java.util.*;
class Solution {
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = 0;
        answer = BFS(0,0,maps,n,m);
        
        return answer;
    }
    public int BFS(int x, int y, int[][] maps, int n, int m){
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        distance[x][y] = 1;
        queue.add(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int p=0; p<4; p++){
                int nx = now[0] + dx[p];
                int ny = now[1] + dy[p];
            
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                continue;
            }
            if(!visited[nx][ny] && maps[nx][ny] == 1){
                distance[nx][ny] = distance[now[0]][now[1]] + 1;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx,ny});
            }
        
            }
        }
        
        if(distance[n-1][m-1] == 0){
            return -1;
        } else {
            return distance[n-1][m-1];
        }
        
        
        
    }
}