import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int x, y;
    static int K;
    static int order;
    static boolean in_area = false;
    static int[][] map;
    static int[] dice;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int temp_up, temp_down, temp_left, temp_right, temp_front, temp_back;

    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dice = new int[6];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order = Integer.parseInt(st.nextToken());
            in_area = false;
            move(order);
            if (!in_area) {
                continue;
            }
            switch(order){
                case 1:
                    turn1();
                    break;
                case 2:
                    turn2();
                    break;
                case 3:
                    turn3();
                    break;
                case 4:
                    turn4();
                    break;
            }
            answer = getNum();
            System.out.println(answer);
        }

    }

    public static void move(int now_order) {
        int tempX = x + dx[now_order];
        int tempY = y + dy[now_order];

        // 범위 초과하지 않으면 이동
        if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < M) {
            in_area = true;
            x = x + dx[now_order];
            y = y + dy[now_order];
        }
    }
    public static int getNum(){
        if (map[x][y] == 0) {
            map[x][y] = dice[1];
        }
        else{
            dice[1] = map[x][y];
            map[x][y] = 0;
        }
        return dice[0];
    }
    public static void turn1(){
        temp_up = dice[0];
        temp_down = dice[1];
        temp_left = dice[2];
        temp_right = dice[3];
        dice[0] = temp_left;
        dice[1] = temp_right;
        dice[2] = temp_down;
        dice[3] = temp_up;
    }
    public static void turn2(){
        temp_up = dice[0];
        temp_down = dice[1];
        temp_left = dice[2];
        temp_right = dice[3];
        dice[0] = temp_right;
        dice[1] = temp_left;
        dice[2] = temp_up;
        dice[3] = temp_down;
    }
    public static void turn3(){
        temp_up = dice[0];
        temp_down = dice[1];
        temp_front = dice[4];
        temp_back = dice[5];
        dice[0] = temp_back;
        dice[1] = temp_front;
        dice[4] = temp_up;
        dice[5] = temp_down;
    }
    public static void turn4(){
        temp_up = dice[0];
        temp_down = dice[1];
        temp_front = dice[4];
        temp_back = dice[5];

        dice[0] = temp_front;
        dice[1] = temp_back;
        dice[4] = temp_down;
        dice[5] = temp_up;
    }
}

