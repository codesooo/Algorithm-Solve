import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] number = new int [N+M];
        for(int i=0; i<N; i++) { // 0 1
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=N; i<N+M; i++){ // 2 3
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        for(int i:number)
            bw.write(i+" ");

        bw.flush();
        bw.close();
        br.close();
    }
}