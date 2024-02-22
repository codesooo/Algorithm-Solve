import java.io.*;
import java.util.*;


public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0, -1, -1, +1, +1};
    static int[] dy = {0, 0, -1, +1, -1, +1, -1, +1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            // 1. map 정보 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. dfs
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j]==1 && visited[i][j]==false){
                        answer++;
                        dfs(i,j);
                    }
                }
            }
            // 3. 출력

            System.out.println(answer);
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for (int p = 0; p < dx.length; p++) {
            int newX = x + dx[p];
            int newY = y + dy[p];

            if (newX >= 0 && newY >= 0 && newX < h && newY < w) {
                if (visited[newX][newY] == false && map[newX][newY]==1) {
                    dfs(newX, newY);
                }
            }
        }

    }
}
