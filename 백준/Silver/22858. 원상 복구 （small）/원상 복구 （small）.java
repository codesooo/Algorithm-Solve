import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1];
        int[] D = new int[N+1];
        int[] P = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        while (K-- > 0) {
            for (int i = 1; i <= N; i++) {
                P[D[i]] = S[i];
            }
            for (int i = 1; i <= N; i++) {
                S[i] = P[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(P[i] + " ");
        }

    }
}
