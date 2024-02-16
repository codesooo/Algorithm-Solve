import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0;
        int start = 0, end = 0;
        int count = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(start != N){


            if(sum >=M){
                sum -= arr[start];
                start++;
            }
            else if(end == N){
                break;
            }
            else{
                sum += arr[end];
                end++;
            }

            if(sum == M){
                count++;
            }


        }
        System.out.println(count);
    }
}
