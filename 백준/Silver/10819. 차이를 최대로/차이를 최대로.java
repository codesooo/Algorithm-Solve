import java.io.*;
import java.util.*;
public class Main {
    static int max = 0;
    static int N;
    static int[] A;
    static ArrayList<Integer> arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        visited = new boolean[N];
        arr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        rec(0);
        System.out.println(max);
    }
    public static void rec(int num){    // 현재 선택한 숫자의 개수
        if(num == N){
            int subSum = 0;
            for(int i=0; i<N-1; i++){
                subSum += Math.abs(arr.get(i) - arr.get(i+1));
            }
            max = Math.max(max, subSum);
            return;
        }
        for(int i=0; i<N; i++){
            if (visited[i] == false) {
                arr.add(A[i]);
                visited[i] = true;
                rec(num+1);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }

    }
}
