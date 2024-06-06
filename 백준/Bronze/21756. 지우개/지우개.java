import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        while(true){
            if (exit(arr)) {
                break;
            }
            ArrayList<Integer> leftNums = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (i % 2 != 0) {   // 홀수이면
                    arr[i] = 0;
                } else if (arr[i] != 0) {
                    leftNums.add(arr[i]);
                }
            }
            arr = new int[N+1];
            for (int i = 1; i <= leftNums.size(); i++) {
                arr[i] = leftNums.get(i-1);
            }
        }

        System.out.println(arr[1]);
    }

    static boolean exit(int[] arr) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                cnt++;
            }
        }
        if (cnt > 1) {
            return false;
        } else {
            return true;
        }
    }
}
