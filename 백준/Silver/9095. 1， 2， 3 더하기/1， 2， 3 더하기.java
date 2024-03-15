import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int[] dp = new int[N+1];
            for(int j=1; j<N+1; j++){
                if(j==1) dp[1]=1;
                else if(j==2) dp[2]=2;
                else if(j==3) dp[3]=4;
                else{
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
            }


            System.out.println(dp[N]);
        }
    }
}
