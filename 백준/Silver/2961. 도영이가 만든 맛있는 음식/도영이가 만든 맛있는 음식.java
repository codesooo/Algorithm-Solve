import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] S; // 입력받은 신맛
    static int[] B; // 입력받은 쓴맛

    static ArrayList<Integer> S_arr;    // 생성한 신맛 조합 저장
    static ArrayList<Integer> B_arr;    // 생성한 쓴맛 조합 저장
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static int S_sum;
    static int B_sum;

    public static void main(String[] args) throws IOException{
        S_arr = new ArrayList<>();
        B_arr = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = new int[N];
        B = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        rec(0);
        System.out.println(min);
    }
    public static void rec(int cnt){

        if(cnt == N){
            return;
        }

        for(int i=0; i<N; i++){
            S_sum = 1;
            B_sum = 0;
            if(visited[i] == false){
                S_arr.add(S[i]);
                B_arr.add(B[i]);
                visited[i] = true;
                for(int j=0; j<S_arr.size(); j++){
                    S_sum *= S_arr.get(j);
                    B_sum += B_arr.get(j);
                }
                min = Math.min(min, Math.abs(S_sum - B_sum));
                rec(cnt+1);
                S_arr.remove(S_arr.size()-1);
                B_arr.remove(B_arr.size()-1);
                visited[i] = false;
            }
        }
    }
}
