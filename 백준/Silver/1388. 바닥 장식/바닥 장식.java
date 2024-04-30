import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        int answer = 0;

        // 0. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        // 1. 구현
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && maps[i][j] == '-') {
                    DFS1(i,j);
                    answer++;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (!visited[i][j] && maps[i][j] == '|') {
                    DFS2(i,j);
                    answer++;
                }
            }
        }

        // 2. 출력
        System.out.println(answer);


    }

    private static void DFS1(int x, int y) {
        if (y == M) {
            return;
        }

        if (maps[x][y] == '-') {
            visited[x][y] = true;
            DFS1(x,y+1);
        }
    }
    private static void DFS2(int x, int y) {
        if (x == N) {
            return;
        }

        if (maps[x][y] == '|') {
            visited[x][y] = true;
            DFS2(x+1,y);
        }
    }
}
