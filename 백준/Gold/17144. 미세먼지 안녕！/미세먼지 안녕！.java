import java.util.*;
import java.io.*;

public class Main {
    static int R, C, T;
    static int answer=0;
    static int[][] map;
    static int[][] newmap;
    static boolean[][] exisdust;
    static LinkedList<Integer> upClean;
    static LinkedList<Integer> downClean;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> cleaningLoc = new ArrayList<>();
    static int clean_up, clean_down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        newmap = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                newmap[i][j] = map[i][j];
                if (map[i][j] == -1) {
                    cleaningLoc.add(i);   // 공기청정기 x좌표 저장 (y좌표는 무조건 0임)
                }
            }
        }

        // 공기청정기의 x좌표 위,아래 저장
        clean_up = cleaningLoc.get(0);
        clean_down = cleaningLoc.get(1);

        // 구현
        while(T!=0){
            exisdust = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        exisdust[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] >= 5 && exisdust[i][j]) {
                        dust(i, j); // 미세먼지 확산
                    }
                }
            }

            // 공기청정기 작동
            clean();

            T--;
        }
        // 남아있는 미세먼지 양 구하기
        getAnswer();

        // 출력
        System.out.println(answer);


    }

    public static void dust(int x, int y) {
        int cnt=0;
        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) {
                continue;
            }
            cnt++;
            newmap[nx][ny] += map[x][y] / 5;
        }
        newmap[x][y] = newmap[x][y] - (map[x][y] / 5) * cnt;

    }
    public static void clean(){
        upClean = new LinkedList<>();
        downClean = new LinkedList<>();

        // 1) 위쪽 공기청정기 작동
        for (int j = 0; j < C; j++) {
            upClean.add(newmap[0][j]);  // 맨 윗줄 좌표
        }
        for (int i = 1; i <= clean_up; i++) {
            upClean.add(newmap[i][C - 1]);
        }
        for (int j = C - 2; j >= 1; j--) {
            upClean.add(newmap[clean_up][j]);
        }
        for (int i = clean_up; i >= 1; i--) {
            upClean.add(newmap[i][0]);
        }

        // 맨 앞의 것을 맨 뒤로 이동시키기
        upClean.add(upClean.removeFirst());

        // 바람 작동
        for (int j = 0; j < C; j++) {
            newmap[0][j] = upClean.removeFirst();
        }
        for (int i = 1; i <= clean_up; i++) {
            newmap[i][C - 1] = upClean.removeFirst();
        }
        for (int j = C - 2; j >= 1; j--) {
            newmap[clean_up][j] = upClean.removeFirst();
        }
        for (int i = clean_up; i >= 1; i--) {
            newmap[i][0] = upClean.removeFirst();
        }


        // 2) 아래쪽 공기청정기 작동
        for (int j = 0; j < C; j++) {
            downClean.add(newmap[clean_down][j]);
        }
        for (int i = clean_down+1; i <R; i++) {
            downClean.add(newmap[i][C - 1]);
        }
        for (int j = C - 2; j >= 0; j--) {
            downClean.add(newmap[R-1][j]);
        }
        for (int i = R-2; i >= clean_down; i--) {
            downClean.add(newmap[i][0]);
        }

        // 맨 뒤쪽을 앞으로
        downClean.addFirst(downClean.removeLast());

        // 바람 작동
        for (int j = 0; j < C; j++) {
            newmap[clean_down][j] = downClean.removeFirst();
        }
        for (int i = clean_down+1; i <R; i++) {
            newmap[i][C - 1] = downClean.removeFirst();
        }
        for (int j = C - 2; j >= 0; j--) {
            newmap[R-1][j] = downClean.removeFirst();
        }
        for (int i = R-2; i >= clean_down; i--) {
            newmap[i][0] = downClean.removeFirst();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newmap[i][j] == -1) {
                    newmap[i][j] = 0;   // 공기청정기 값이 이동한 자리는 다시 0으로 바꿔줌
                }
            }
        }

        // 공기청정기 자리 다시 만들어주기
        newmap[clean_up][0] = -1;
        newmap[clean_down][0] = -1;

        for (int i = 0; i < R; i++) {
            System.arraycopy(newmap[i], 0, map[i], 0,map[i].length);
        }

    }
    public static void getAnswer(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }
    }
}
