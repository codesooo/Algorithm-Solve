import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map = new int[501][501];
    private static int T, N, D;
    private static int[] temp = new int[501];
    public static void main(String[] args) throws IOException {

        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 구현
            boolean flag = true;
            if (D < 0) {
                flag = false;
            }
            int rotateCnt = Math.abs(D / 45);

            // D < 0 이면
            if (!flag) {
                while (rotateCnt-- > 0) {
                    rotateNegative();
                }
            }

            // D > 0 이면
            else{
                while (rotateCnt-- > 0) {
                    rotatePositive();
                }
            }

            // 3. 출력
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    private static void rotateNegative() {
        // 1) 주대각선 저장
        for (int i = 1; i <= N; i++) {
            temp[i] = map[i][i];
        }

        // 2) 주대각선 = 가운데 열
        for (int i = 1; i <= N; i++) {
            map[i][i] = map[i][(N + 1) / 2];
        }

        // 3) 가운데 열 = 부대각선
        for (int i = 1; i <= N; i++) {
            map[i][(N + 1) / 2] = map[i][N - i + 1];
        }

        // 4) 부대각선 = 가운데 행
        for (int i = 1; i <= N; i++) {
            map[N - i + 1][i] = map[(N + 1) / 2][i];
        }

        // 5) 가운데 행 = 주대각선
        for (int i = 1; i <= N; i++) {
            map[(N + 1) / 2][i] = temp[i];
        }

    }

    private static void rotatePositive() {

        // 1) 주대각선 저장
        for (int i = 1; i <= N; i++) {
            temp[i] = map[i][i];
        }

        // 2) 주대각선 = 가운데 행
        for (int i = 1; i <= N; i++) {
            map[i][i] = map[(N + 1) / 2][i];
        }

        // 3) 가운데 행 =  부대각선
        for (int i = 1; i <= N; i++) {
            map[(N + 1) / 2][i] = map[N - i + 1][i];
        }

        // 4) 부대각선 = 가운데 열
        for (int i = 1; i <= N; i++) {
            map[i][N - i + 1] = map[i][(N + 1) / 2];
        }

        // 5) 가운데 열 = 주대각선
        for (int i = 1; i <= N; i++) {
            map[i][(N + 1) / 2] = temp[i];
        }


    }


}
