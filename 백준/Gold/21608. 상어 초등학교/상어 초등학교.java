import java.io.*;
import java.util.*;
public class Main {
    static class Info implements Comparable<Info>{
        int x;
        int y;
        int cnt_love;
        int cnt_blank;

        Info(int x, int y, int cnt_love, int cnt_blank) {
            this.x = x;
            this.y = y;
            this.cnt_love = cnt_love;
            this.cnt_blank = cnt_blank;
        }

        @Override
        public int compareTo(Info o){
            if(o.cnt_love == this.cnt_love){
                if(o.cnt_blank == this.cnt_blank){
                    if(o.x == this.x){
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.cnt_blank - this.cnt_blank;
            }
            return o.cnt_love - this.cnt_love;
        }
    }
    static int N, st_num;
    static int[] student;
    static int[][] loveStudent;
    static int[][] classroom;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st_num = N * N;
        student = new int[st_num];
        loveStudent = new int[st_num][4];
        classroom = new int[N][N];
        // 입력받기
        for (int i = 0; i < st_num; i++) {
            st = new StringTokenizer(br.readLine());
            student[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                loveStudent[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        classroom[1][1] = student[0];
        for (int i = 1; i < st_num; i++) {
            te(i);
        }
        getAnswer();
        System.out.println(answer);
    }
    public static void te(int now_st){
        PriorityQueue<Info> pQ = new PriorityQueue<Info>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (classroom[i][j] != 0) {
                    continue;
                }
                int cnt_love = 0;
                int cnt_blank = 0;
                if (classroom[i][j] == 0) {
                    for (int p = 0; p < 4; p++) {
                        int now_x = i + dx[p];
                        int now_y = j + dy[p];
                        if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= N) {
                            continue;
                        }
                        for (int l = 0; l < 4; l++) {
                            if(classroom[now_x][now_y] == loveStudent[now_st][l]){
                                cnt_love++;
                            }
                        }
                        if(classroom[now_x][now_y] == 0){
                            cnt_blank++;
                        }
                    }
                }
                pQ.add(new Info(i,j,cnt_love,cnt_blank));
            }
        }
        int x = pQ.peek().x;
        int y = pQ.peek().y;
        classroom[x][y] = student[now_st];
    }

    public static void getAnswer(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    getSum(classroom[i][j], i,j);
            }
        }
    }
    public static void getSum(int now_st, int x, int y){
        int cnt = 0;
        for(int i=0; i<st_num; i++){
            if(student[i] == now_st){
                for (int l = 0; l < 4; l++) {
                    for (int p = 0; p < 4; p++) {
                        int now_x = x + dx[p];
                        int now_y = y + dy[p];
                        if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= N) {
                            continue;
                        }
                        if (classroom[now_x][now_y] == loveStudent[i][l]) {
                        cnt++;
                        }
                    }
                }
            }
            }
        switch (cnt){
            case 1:
                answer += 1;
                break;
            case 2:
                answer += 10;
                break;
            case 3:
                answer += 100;
                break;
            case 4:
                answer += 1000;
                break;
        }
    }

}
