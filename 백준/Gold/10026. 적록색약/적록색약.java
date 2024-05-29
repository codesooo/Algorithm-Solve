import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        int answer1 = 0;
        int answer2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    dfs1(i, j);
                    answer1++;
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    dfs2(i, j);
                    answer2++;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    public static void dfs1(int x, int y) {
        visited1[x][y] = true;

        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (!visited1[nx][ny] && map[nx][ny] == map[x][y]) {
                dfs1(nx, ny);
            }
        }
    }

    public static void dfs2(int x, int y) {
        visited2[x][y] = true;
        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (!visited2[nx][ny]) {
                if ((map[x][y] == 'R' && map[nx][ny] == 'G') ||
                        (map[x][y] == 'G' && map[nx][ny] == 'R') ||
                        (map[x][y] == map[nx][ny])) {
                    dfs2(nx, ny);
                }
            }
        }
    }
}
