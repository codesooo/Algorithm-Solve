import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> positivePQ = new PriorityQueue<>();  // 양수
        PriorityQueue<Integer> negativePq = new PriorityQueue<>(Collections.reverseOrder());  // 정수


        for (int i = 0; i < N; i++) {
            // 입력받기
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x != 0) {
                if (x > 0) {
                    positivePQ.offer(x);
                } else {
                    negativePq.offer(x);
                }
            } else {
                if (positivePQ.isEmpty() && negativePq.isEmpty()) {
                    answer = 0;
                } else if (positivePQ.isEmpty()) {
                    answer = negativePq.poll();
                } else if (negativePq.isEmpty()) {
                    answer = positivePQ.poll();
                } else {
                    int p1 = Math.abs(positivePQ.peek());
                    int n1 = Math.abs(negativePq.peek());

                    if(p1 < n1) { answer = positivePQ.poll(); }
                    else if(p1 > n1){ answer = negativePq.poll(); }
                    else{ answer = negativePq.poll(); }

                }
                System.out.println(answer);
            }
        }
    }
}
