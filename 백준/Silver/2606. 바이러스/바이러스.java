import java.util.*;
import java.io.*;
public class Main {
    static boolean[][] linkedGraph;
    static boolean[] visited;
    static int pcNum,twinNum;
    static int answer;

    public static void main(String[] args) throws IOException{
        // 0. 입력 및 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        pcNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        twinNum = Integer.parseInt(st.nextToken());

        linkedGraph = new boolean[pcNum+1][pcNum+1];
        visited = new boolean[pcNum+1];

        // 1. 연결 정보 입력
        int x, y;
        for(int i=0; i<twinNum; i++){
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            linkedGraph[x][y] = true;
            linkedGraph[y][x] = true;
        }

        dfs(1); // 1번 PC부터 시작

        System.out.println(answer-1);

    }
    public static void dfs(int idx){
        visited[idx] = true;
        answer++;

        for(int i=1; i<=pcNum; i++){
            if(visited[i] == false && linkedGraph[idx][i] == true){
                dfs(i);
            }
        }
    }
}
