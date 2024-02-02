import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());    // N 입력
        int N = Integer.parseInt(st.nextToken());
        int[] ingred = new int[N];

        st = new StringTokenizer(bf.readLine());    // M 입력
        int M = Integer.parseInt(st.nextToken());
        
        int count = 0;
        st = new StringTokenizer(bf.readLine());    // 재료 입력
        for(int i=0; i<N; i++){
            ingred[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N-1; i++){
            for(int j=i+1;j<N; j++){
                if(ingred[i] + ingred[j] == M){
                    count++;
                }
            }
        }

        System.out.println(count);

    }


}

