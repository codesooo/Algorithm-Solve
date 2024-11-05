import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException{
        // 0. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 한 변 길이

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            bfs(startX, startY, endX, endY);

            System.out.println(map[endX][endY]);
        }
    }

    private static void bfs(int sX, int sY, int eX, int eY) {
        visited[sX][sY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sX, sY});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == eX && y == eY) {
                return;
            }

            for (int p = 0; p < dx.length; p++) {
                int nx = x + dx[p];
                int ny = y + dy[p];

                // 범위를 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                // 이미 방문한 경우
                if (visited[nx][ny]) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = map[x][y] + 1;
            }
        }
    }
}
