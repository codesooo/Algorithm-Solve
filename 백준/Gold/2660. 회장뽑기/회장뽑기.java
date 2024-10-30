import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] d;
    private static final int INF = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = new int[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                d[i][j] = INF;
            }
        }

        // 친구 관계 입력 받고, 배열 정보 업데이트
        while (true) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if (p1 == -1 && p2 == -1) {
                break;
            }
            d[p1][p2] = 1;
            d[p2][p1] = 1;
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        int[] sumArr = new int[N + 1];
        int minsum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += d[i][j];
            }
            sumArr[i] = sum;
            if (minsum > sum) {
                minsum = sum;
            }
        }

        List<Integer> masters = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (minsum == sumArr[i]) {
                masters.add(i);
            }
        }

        int n = masters.get(0);
        int maxNum = 0;
        for (int i = 1; i <= N; i++) {
            if (maxNum < d[n][i]) {
                maxNum = d[n][i];
            }
        }

        int masterScore = maxNum;
        int masterCnt = masters.size();
        System.out.println(masterScore + " " + masterCnt);

        Collections.sort(masters);
        for (int master : masters) {
            System.out.print(master + " ");
        }

    }

}
