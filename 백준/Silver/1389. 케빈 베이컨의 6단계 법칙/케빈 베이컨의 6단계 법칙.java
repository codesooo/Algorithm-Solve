import java.io.*;
import java.util.*;
public class Main {
    private static int N, M;
    private static int[][] d;
    private static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        input();

        solution();

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int minSum = Integer.MAX_VALUE, minNum = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += d[i][j];
            }
            if (minSum > sum) {
                minSum = sum;
                minNum = i;
            }
            if (minSum == sum) {
                minNum = Math.min(i, minNum);
            }
        }

        return minNum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                d[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            d[A][B] = 1;
            d[B][A] = 1;
        }
    }

    private static void solution() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
