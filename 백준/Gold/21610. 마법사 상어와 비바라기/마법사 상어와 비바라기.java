import java.io.*;
import java.util.*;

public class Main {
    static int N, M, d, s, answer = 0;

    static int[][] map;
    static boolean[][] cloud;
    static boolean[][] tempCloud;
    
    // 2,4,6,8 방향 순
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
//        order = new int[2];
        cloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {   // 지도 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름 생성
        newCloud();

        for (int i = 0; i < M; i++) {   // 명령 입력
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            moveCloud();    // 구름 이동
            Rain();         // 구름에서 비를 내림
            copyWater();    // 물 복사 마법 시전
            subWater();     // 물의 양 2씩 제거
        }

        // 답 구하기
        getAnswer();
        System.out.println(answer);

    }
    public static void newCloud(){
        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true;
    }

    public static void moveCloud(){
        tempCloud = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(cloud[i][j]){ // 구름이 존재하면
                    int up_x = i - (s % N);
                    if (up_x < 0) {
                        up_x = N + up_x;
                    }
                    int down_x = (i + s) % N;
                    int left_y = j - (s % N);
                    if (left_y < 0) {
                        left_y = N + left_y;
                    }
                    int right_y = (j + s) % N;
                    switch (d){
                        case 1:
                            tempCloud[i][left_y] = true;
                            break;
                        case 2:

                            tempCloud[up_x][left_y] = true;
                            break;
                        case 3:
                            tempCloud[up_x][j] = true;
                            break;
                        case 4:
                            tempCloud[up_x][right_y] = true;
                            break;
                        case 5:
                            tempCloud[i][right_y] = true;
                            break;
                        case 6:
                            tempCloud[down_x][right_y] = true;
                            break;
                        case 7:
                            tempCloud[down_x][j] = true;
                            break;
                        case 8:
                            tempCloud[down_x][left_y] = true;
                            break;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(tempCloud[i], 0, cloud[i],0, tempCloud.length);
        }
    }

    public static void Rain(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {  // 구름이 존재하면
                    map[i][j] += 1; // 비를 내림
                }
            }
        }
    }

    public static void copyWater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    int cnt = 0;
                    for (int p = 0; p < 4; p++) {
                        int nx = i + dx[p];
                        int ny = j + dy[p];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }
                        if (map[nx][ny] > 0) {   // 물이 존재하는 칸 개수 세기
                            cnt++;
                        }
                    }
                    map[i][j] += cnt;
                }
            }
        }
    }

    public static void subWater() {
        tempCloud = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    if(!cloud[i][j]){
                        tempCloud[i][j] = true;
                        map[i][j] -= 2;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(tempCloud[i], 0, cloud[i],0, tempCloud.length);
        }
    }
    public static void getAnswer(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }
    }
}
