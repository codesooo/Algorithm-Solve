import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> card = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            card.offer(Long.valueOf(st.nextToken()));
        }
        while (m-- > 0) {
            long x = card.poll();
            long y = card.poll();

            card.offer(x+y);
            card.offer(x+y);
        }

        long answer = 0;
        for (Long c : card) {
            answer += c;
        }

        System.out.println(answer);
    }
}
