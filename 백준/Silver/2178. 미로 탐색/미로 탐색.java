import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] A;
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for (int  j=0; j<M; j++){
                A[i][j] = Integer.parseInt(str.substring(j,j+1));
            }

        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }
    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0;k<4;k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x < N && y < M ){
                    if (!visited[x][y] && A[x][y]!=0){
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y});
                    }                }            }       }   }
}
