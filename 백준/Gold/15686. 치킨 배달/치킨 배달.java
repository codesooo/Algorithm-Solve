import java.io.*;
import java.util.*;
public class Main {
    static int[][] city;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> home;
    static int[][] output;
    static int chicken_road;

    static int city_chicken_road = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   // 치킨 집 최대 개수

        city = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chicken.add(new int[] {i,j});
                }
                else if(city[i][j] == 1){
                    home.add(new int[] {i,j});
                }

            }

        }
        output = new int[M][2];
        combi(0,0);
        System.out.println(city_chicken_road);
    }
    public static void combi(int cnt, int start){
        if(cnt == M){
            chickenRoad();
            city_chicken_road = Math.min(city_chicken_road, chicken_road);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            output[cnt][0] = chicken.get(i)[0];
            output[cnt][1] = chicken.get(i)[1];
            combi(cnt+1, i+1);
        }
    }

    public static void chickenRoad() {
        int compare_road = 0;
        chicken_road = 0;
        for (int i = 0; i < home.size(); i++) {
            int min_chicken_road = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                compare_road = Math.abs(output[j][0] - home.get(i)[0]) + Math.abs(output[j][1] - home.get(i)[1]);
                if (M > 1) {
                    min_chicken_road = Math.min(compare_road, min_chicken_road);
                }
            }
            if (M > 1) {
                chicken_road += min_chicken_road;
            }
            else{
                chicken_road += compare_road;
            }

        }
    }

}
