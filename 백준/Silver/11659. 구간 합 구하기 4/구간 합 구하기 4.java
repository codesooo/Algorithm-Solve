import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long [] arr = new long[N];  // 합 배열 선언
        // long형으로 선언한 이유 : 덧셈이나 곱셈이 많을 때,
        // int 형으로 선언하면 범위를 초과하여 잘못된 값이 나올 수 있음

        // ---- st에서 token을 다 꺼냈으므로 st는 비어있음!

        st = new StringTokenizer(br.readLine());    // st에 새로운 문자열 입력
        // st = "5 4 3 2 1"
        for(int i=0; i<N; i++){
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            else{
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }

        }

        // ---- st에서 token을 다 꺼냈으므로 st는 비어있음!

        for(int q=0; q<M; q++){
            st = new StringTokenizer(br.readLine());
            int q1 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            if (q1 == 1){
                System.out.println(arr[q2-1]);
            }
            else{
                System.out.println(arr[q2-1] - arr[q1-2]);
            }

        }

    }
}
