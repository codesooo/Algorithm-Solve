import java.io.*;
import java.util.*;

public class Main {
    final static int MAX = 50+10;
    static int T, M, N, K;
    // 테스트 케이스 수, 배추밭의 가로 길이, 세로 길이, 배추 위치의 개수
    static boolean[][] graph;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for (int p = 0; p < 4; p++) {
            int newY = y + dy[p];
            int newX = x + dx[p];

            if (newX > 0 && newY > 0 && newX < M+1 && newY < N+1) {
                if (visited[newY][newX]==false && graph[newY][newX]==true) {
                    dfs(newY,newX);
                }
            }


        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());



        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. graph 정보 반영
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y+1][x+1] = true;
            }


            // 2. dfs 수행
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(graph[i][j] == true && visited[i][j]==false){
                        answer++;
                        dfs(i,j);
                    }
                }
            }


            System.out.println(answer);

        }




    }
}
