import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            long answer = 0;
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pQ = new PriorityQueue<>();
            while(K-- > 0){
                pQ.offer(Long.parseLong(st.nextToken()));
            }

            while (pQ.size() > 1) {
                for (int i = 0; i < (pQ.size() / 2); i++) {
                    long sum = pQ.poll() + pQ.poll();
                    answer += sum;
                    pQ.offer(sum);
                }
            }
            System.out.println(answer);
        }


    }
}
