import java.io.*;
import java.util.*;
class FireBall {
    int r,c,m,s,d;

    FireBall(int r, int c, int m, int s, int d) {
        this.r = r; // x좌표
        this.c = c; // y좌표
        this.m = m; // 질량
        this.s = s; // 속력
        this.d = d; // 방향
    }
}
public class Main{
    static int N, M, K, answer;
    static int r,c,m,s,d;
    static ArrayList<FireBall>[][] map;
    static ArrayList<FireBall> list;
    // 0,1,2,3,4,5,6,7 방향
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 입력받기 */
        N = Integer.parseInt(st.nextToken());   // 배열 크기 : N*N
        M = Integer.parseInt(st.nextToken());   // 파이어볼 개수
        K = Integer.parseInt(st.nextToken());   // 명령 실행 횟수

        list = new ArrayList<>();
        map = new ArrayList[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            list.add(new FireBall(r, c, m, s, d));

        }

        /* 구현 */
        while(true){
            if (K == 0) {
                break;
            }
            moveBall(); // 파이어볼 이동

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() >= 2) {
                        mergeBall(i,j, map[i][j]); // 파이어볼 합치기

                    }
                }
            }
            cleanList();
            K--;
        }


        getAnswer();
        System.out.println(answer);



    }
    public static void moveBall(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (FireBall ball : list) {
            r = ball.r;
            c = ball.c;
            m = ball.m;
            d = ball.d;
            s = ball.s;
            r = (N + r + dx[d] * (s%N)) % N;
            ball.r = r;
            c = (N + c + dy[d] * (s%N)) % N;
            ball.c = c;

            map[r][c].add(ball);
        }
    }

    public static void mergeBall(int x, int y, ArrayList<FireBall> fireBalls) {
        int m_sum = 0, s_sum = 0;
        int odd = 0, even = 0;
        for (FireBall ball : fireBalls) {
            m_sum += ball.m;
            s_sum += ball.s;
            if (ball.d % 2 == 0) {
                even += 1;
            }else{
                odd += 1;
            }
        }
        m = m_sum / 5;

        s = s_sum / fireBalls.size();

        if (even == fireBalls.size() || odd == fireBalls.size()) {  // 방향이 모두 홀수거나 짝수이면
            d = 0;  // d는 0,2,4,8
        }else{
            d = 1;  // d는 1,3,5,7
        }

        map[x][y] = new ArrayList<>();
        if (m != 0) {
            for (int i = 0; i < 4; i++) {   // 나누어진 파이어볼 4개 저장
                map[x][y].add(new FireBall(x, y, m, s, 2 * i + d));
            }
        }

    }

    public static void cleanList() {
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (FireBall ball : map[i][j]) {
                        list.add(ball);
                    }
                }
            }
        }
    }

    public static void getAnswer() {
        for (FireBall ball : list) {
            answer += ball.m;
        }
    }


}