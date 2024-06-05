import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        int N = Integer.parseInt(st.nextToken());   // 전구 개수
        int M = Integer.parseInt(st.nextToken());   // 명령어 개수
        int[] lights = new int[N + 1];  // 전구 상태

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    lights[b] = c;
                    break;
                case 2:
                    for (int i = b; i <= c; i++) {
                        if (lights[i] == 1) {
                            lights[i] = 0;
                        } else {
                            lights[i] = 1;
                        }
                    }
                    break;
                case 3:
                    for (int i = b; i <= c; i++) {
                        lights[i] = 0;
                    }
                    break;
                case 4:
                    for (int i = b; i <= c; i++) {
                        lights[i] = 1;
                    }
                    break;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(lights[i] + " ");
        }
    }
}
