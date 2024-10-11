import java.io.*;
import java.util.*;

public class Main {
    private static int[][] calendar = new int[1000][365 + 2];
    private static int ans = 0;
    private static int maxDate = 0;
    private static int maxHeight = 0;
    private static PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> {
        if (p1[0] != p2[0]) {
            return Integer.compare(p1[0], p2[0]);
        }
        return Integer.compare(p2[1], p1[1]);
    });

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력받기
        int N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            priorityQueue.add(new int[]{start, end});
        }

        // 2. 구현
        // 캘린더 채우기
        fillCalendar();

        // 코팅지 만들기
        makingCoating();

        // 3. 출력
        System.out.println(ans);


    }

    private static void fillCalendar() {
        while (!priorityQueue.isEmpty()) {
            int h = -1;
            int start = priorityQueue.peek()[0];
            int end = priorityQueue.poll()[1];
            maxDate = Math.max(end, maxDate);
            while (true) {
                h++;
                if (calendar[h][start] == 0) {
                    for (int i = start; i <= end; i++) {
                        calendar[h][i] = 1;
                        maxHeight = Math.max(h, maxHeight);

                    }
                    break;
                }
            }
        }
    }

    private static void makingCoating() {
        Queue<Integer> queue = new LinkedList<>();
        // calendar[0] ~ calendar[maxHeight] 모두 0인 열 구하기
        for (int i = 0; i <= maxDate; i++) {
            boolean flagBefore = true;
            boolean flag = false;
            for (int j = 0; j <= maxHeight; j++) {
                if (calendar[j][i] == 1) {     // 현재 열에 1이 존재하면
                    flagBefore = false;
                }
                if (calendar[j][i+1] == 1) {  // 다음 열에 1이 존재하면
                    flag = true;
                }
            }
            // 현재 열이 모두 0이고, 다음 열에 1이 존재할 때
            if (flagBefore && flag) {
                queue.add(i+1);
            }
            // 현재 열에 1이 존재하고, 다음 열이 모두 0일 때
            if (!flagBefore && !flag) {
                queue.add(i);
            }

            if (queue.size() == 2) {
                // 가로 길이 구하기
                int start = queue.poll();
                int end = queue.poll();
                int width = end - start + 1;

                // 세로 길이 구하기
                int height = 0;
                for (int j = 1; j <= maxHeight+1; j++) {
                    for (int m = start; m <= end; m++) {
                        if (calendar[j-1][m] > 0 && j != height) {
                            height = j;
                        }
                    }
                    if (height < j) {
                        break;
                    }
                }
                ans += width * height;
            }
        }

    }
}
