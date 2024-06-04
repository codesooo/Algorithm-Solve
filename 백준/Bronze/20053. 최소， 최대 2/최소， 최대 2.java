import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            System.out.println(list.get(0) + " " + list.get(N-1));
        }
    }
}
