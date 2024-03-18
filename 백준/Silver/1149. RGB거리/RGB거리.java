import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N][N];
        int[][] minSum = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<3; i++){
            minSum[0][i] = cost[0][i];
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                if(j==0){
                    minSum[i][j] = Math.min(minSum[i-1][1], minSum[i-1][2]) + cost[i][j];
                }
                else if(j==1){
                    minSum[i][j] = Math.min(minSum[i-1][0], minSum[i-1][2]) + cost[i][j];
                }
                else{
                    minSum[i][j] = Math.min(minSum[i-1][0], minSum[i-1][1]) + cost[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE ;
        for(int i=0; i<3; i++){
            if(ans > minSum[N-1][i]){
                ans = minSum[N-1][i];
            }
        }

        System.out.println(ans);
    }
}
