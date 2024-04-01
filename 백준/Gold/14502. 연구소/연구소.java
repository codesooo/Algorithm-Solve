import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] copymap;
    static int[][] output;
    static ArrayList<int[]> canWall;
    static int answer=0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copymap = new int[N][M];
        visited = new boolean[N][M];
        output = new int[3][2];
        canWall = new ArrayList<>();

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    canWall.add(new int[] {i, j});
                }
            }
        }

        // 구현
        combi(0, 0);

        // 출력
        System.out.println(answer);

    }

    public static void combi(int cnt, int start) {
        if (cnt == 3) {
            doWall();
            return;
        }
        for (int i = start; i < canWall.size(); i++) {
            output[cnt][0] = canWall.get(i)[0];
            output[cnt][1] = canWall.get(i)[1];
            combi(cnt + 1, i + 1);
            }

        }
    public static void doWall() {

        // map을 copymap에 복사
        for(int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copymap[i], 0, map[i].length);
        }

        // 벽 세우기
        for (int i = 0; i < 3; i++) {
            copymap[output[i][0]][output[i][1]] = 1;
        }
        
        birus();
        getAnswer();
    }
    
    public static void birus() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
            }
        }


        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int o = 0; o < 4; o++) {
                int nx = now[0] + dx[o];
                int ny = now[1] + dy[o];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (copymap[nx][ny] ==0) { // 벽이 없으면
                    copymap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }

    public static void getAnswer() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.max(cnt, answer);
    }
    }


