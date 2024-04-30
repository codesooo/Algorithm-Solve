import java.util.*;
class Solution {
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int maps_x, maps_y;
    public int solution(int[][] maps) {
        int answer = 0;
        maps_x = maps.length;
        maps_y = maps[0].length;
        distance = new int[maps_x][maps_y];
        visited = new boolean[maps_x][maps_y];
        
        
        
        BFS(0,0, maps);
        
        if(distance[maps_x-1][maps_y-1] == 0){
            return -1;
        } else {
            return distance[maps_x-1][maps_y-1];
        }
    }
    private void BFS(int x, int y, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        distance[x][y] = 1;
        visited[x][y] = true;
        
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int p=0; p<4; p++){
                int nx = now[0] + dx[p];
                int ny = now[1] + dy[p];
                
                if(nx >= maps_x || ny >= maps_y || nx < 0 || ny < 0){
                    continue;
                }
                if(!visited[nx][ny] && maps[nx][ny]==1){
                    distance[nx][ny] = distance[now[0]][now[1]] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx,ny});
                }
            }
            
        }
        
        
        
    }
}