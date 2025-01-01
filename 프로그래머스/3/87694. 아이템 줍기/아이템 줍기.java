import java.util.*;
class Solution {
    private final int MAX_LENGTH = 51 * 2;
    private boolean[][] visited = new boolean[MAX_LENGTH][MAX_LENGTH];
    private int[][] map = new int[MAX_LENGTH][MAX_LENGTH];
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int i=0; i<rectangle.length; i++){
            int lX = rectangle[i][0] * 2;
            int lY = rectangle[i][1] * 2;
            int rX = rectangle[i][2] * 2;
            int rY = rectangle[i][3] * 2;
            
            for(int x=lX; x<=rX; x++){
                for(int y=lY; y<=rY; y++){
                    if(x == lX || x == rX || y == lY || y == rY){
                        if(map[x][y] == -1){
                            continue;
                        }
                        map[x][y] = 1;
                    }
                    else {
                        map[x][y] = -1;
                    }
                }
            }
        }
        
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private int bfs(int cX, int cY, int itemX, int itemY){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cX, cY, 0});
        visited[cX][cY] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dis = now[2];
            if(x == itemX && y == itemY){
                return dis / 2;
            }
            
            for(int p=0; p<4; p++){
                int nx = x + dx[p];
                int ny = y + dy[p];
                
                if(nx<0 || nx>=MAX_LENGTH || ny<0 || ny>=MAX_LENGTH){
                    continue;
                }
                
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[] {nx, ny, dis +1});
                    visited[nx][ny] = true;
                }
                
            }
        }
        return -1;
    
    }
}