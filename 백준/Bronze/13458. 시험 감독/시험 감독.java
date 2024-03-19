import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // N : 시험장의 개수
        int[] tester = new int[N];  // test : 각 시험장에 있는 응시자 수 저장 배열

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            tester[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int B = Integer.parseInt(st.nextToken());   // 총감독관의 감시 가능한 인원
        int C = Integer.parseInt(st.nextToken());   // 부감독관의 감시 가능 인원
        long ans = N;    // 총감독감은 시험장마다 무조건 1명씩 존재
        for(int i=0; i<N; i++){
            if(tester[i] - B > 0){
                ans += Math.ceil((tester[i] - B) / (C*1.0));
            }
        }
        System.out.println(ans);
    }
}
