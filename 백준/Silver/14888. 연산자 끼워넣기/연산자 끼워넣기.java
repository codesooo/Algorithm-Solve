import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] nums;
    static int[] operators = new int[4];
    static int maxAns =  Integer.MIN_VALUE;
    static int minAns =  Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];


        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        Bactracking(nums[0],1);
        System.out.println(maxAns);
        System.out.println(minAns);
    }

    public static void Bactracking(int now, int idx){
        if(idx == N){
            maxAns = Math.max(maxAns, now);
            minAns = Math.min(minAns, now);
            return;
        }

        if(operators[0]>0){
            operators[0]--;
            Bactracking(now + nums[idx], idx+1);
            operators[0]++;
        }
        if(operators[1]>0){
            operators[1]--;
            Bactracking(now - nums[idx], idx+1);
            operators[1]++;
        }
        if(operators[2]>0){
            operators[2]--;
            Bactracking(now * nums[idx], idx+1);
            operators[2]++;
        }
        if(operators[3]>0){
            operators[3]--;
            Bactracking(now / nums[idx], idx+1);
            operators[3]++;
        }
    }
}
