import java.io.*;
import java.util.*;

class CCTV {
    int num;
    int x;
    int y;

    CCTV(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class Main{

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] copymap;

    static ArrayList<CCTV> cctvList;
    static int[] output;
    // 북,동,남,서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvList = new ArrayList<>();

        // 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(map[i][j], i, j));    // cctv가 있으면 cctvList에 저장
                }
            }
        }

        output = new int[cctvList.size()];
        // 구현
        permutation(0);


        // 출력
        System.out.println(answer);
    }
    public static void permutation(int cnt){

        if(cnt == cctvList.size()){
            copymap = new int[N][M];

            for(int i = 0; i < map.length; i++) {
                System.arraycopy(map[i], 0, copymap[i], 0, map[i].length);
            }
            for (int i = 0; i < cctvList.size(); i++) {
                orient(cctvList.get(i), output[i]);
            }

            getAnswer();

            return;
        }
        for (int i = 0; i < 4; i++) {
            output[cnt] = i;
            permutation(cnt + 1);
        }
    }
    public static void orient(CCTV cctv, int now_orient) {
        int cctvNum = cctv.num;
        switch (cctvNum) {
            case 1:
                if (now_orient == 0) {          // 북
                    watch(cctv, 0);
                } else if (now_orient == 1) {   // 동
                    watch(cctv, 1);
                } else if (now_orient == 2) {   // 남
                    watch(cctv, 2);
                } else if (now_orient == 3) {   // 서
                    watch(cctv, 3);
                }
                break;
            case 2:
                if (now_orient == 0 || now_orient == 2) {   // 북남
                    watch(cctv, 0);
                    watch(cctv, 2);
                }
                else {                                      // 동서
                    watch(cctv, 1);
                    watch(cctv, 3);
                }
                break;
            case 3:
                if (now_orient == 0) {          // 북동
                    watch(cctv, 0);
                    watch(cctv, 1);
                } else if (now_orient == 1) {   // 동남
                    watch(cctv, 1);
                    watch(cctv, 2);
                } else if (now_orient == 2) {   // 남서
                    watch(cctv, 2);
                    watch(cctv, 3);
                } else if (now_orient == 3) {   // 서북
                    watch(cctv, 3);
                    watch(cctv, 0);
                }
                break;
            case 4:
                // 북동남,동남서,남서북,서북동
                if (now_orient == 0) {          // 북동남
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 2);
                } else if (now_orient == 1) {   // 동남서
                    watch(cctv, 1);
                    watch(cctv, 2);
                    watch(cctv, 3);
                } else if (now_orient == 2) {   // 남서북
                    watch(cctv, 2);
                    watch(cctv, 3);
                    watch(cctv, 0);
                } else if (now_orient == 3) {   // 서북동
                    watch(cctv, 3);
                    watch(cctv, 0);
                    watch(cctv, 1);
                }
                break;
            case 5:
                watch(cctv,0);
                watch(cctv,1);
                watch(cctv,2);
                watch(cctv,3);
                break;
        }
    }

    public static void watch(CCTV cctv, int now_orient){
        Queue<CCTV> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(cctv);
        visited[cctv.x][cctv.y] = true;

        while (queue.size() != 0) {
            int now_x = queue.peek().x + dx[now_orient];
            int now_y = queue.poll().y + dy[now_orient];

            if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= M || copymap[now_x][now_y] == 6) {
                break;
            }
            if (copymap[now_x][now_y] == 0) {
                copymap[now_x][now_y] = -1;
                queue.add(new CCTV(cctv.num, now_x, now_y));
            } else {
                queue.add(new CCTV(cctv.num, now_x, now_y));
            }
        }
    }

    public static void getAnswer(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.min(cnt, answer);
    }

}
