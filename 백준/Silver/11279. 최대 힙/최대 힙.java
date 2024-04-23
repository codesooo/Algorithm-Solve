import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            if (X > 0) {
                pQ.offer(X);
            } else if (X == 0) {
                if (!pQ.isEmpty()) {
                    System.out.println(pQ.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
