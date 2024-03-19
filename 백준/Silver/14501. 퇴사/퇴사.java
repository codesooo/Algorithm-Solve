import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N + 1];
        int[] P= new int[N + 1];
        int[] dp = new int[N+2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--){
            if(i+T[i] <= N+1){
                dp[i] += Math.max(dp[i+1], dp[i + T[i]] + P[i]);
            }
            else{
                dp[i] += dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}

