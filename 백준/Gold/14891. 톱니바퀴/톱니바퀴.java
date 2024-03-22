import java.util.*;
import java.io.*;
public class Main {
    static LinkedList<Integer>[] top = new LinkedList[4];
    public static void main(String[] args) throws IOException{
        int ans=0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            top[i] = new LinkedList<>();
            String s = bf.readLine();
            for (int j = 0; j < 8; j++) {
                top[i].add(s.charAt(j) - '0');
            }
        }

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());   // 회전 횟수

        while (K > 0) {
            K--;
            st = new StringTokenizer(bf.readLine());
            int top_num = Integer.parseInt(st.nextToken()) - 1;         // 회전시킬 톱니바퀴
            int d = Integer.parseInt(st.nextToken());
            turn_left(top_num - 1, -d);
            turn_right(top_num + 1, -d);

            rotate(top_num,d);
        }

        if (top[0].get(0) == 1) {
            ans += 1;
        }
        if (top[1].get(0) == 1) {
            ans += 2;
        }
        if (top[2].get(0) == 1) {
            ans += 4;
        }
        if (top[3].get(0) == 1) {
            ans += 8;
        }

        System.out.println(ans);
    }

    public static void turn_left(int num, int d) {
        if (num < 0) {
            return;
        }

        if(top[num].get(2) != top[num+1].get(6)){
            turn_left(num - 1, -d);
            rotate(num, d);
        }
    }
    public static void turn_right(int num, int d) {
        if (num > 3) {
            return;
        }
        if(top[num-1].get(2) != top[num].get(6)){
            turn_right(num + 1, -d);
            rotate(num, d);
        }

    }
    public static void rotate(int num, int d){
        switch (d) {
            case 1:
                top[num].addFirst(top[num].get(7));
                top[num].removeLast();
                break;
            case -1:
                top[num].addLast(top[num].getFirst());
                top[num].removeFirst();
                break;

        }
    }
}
