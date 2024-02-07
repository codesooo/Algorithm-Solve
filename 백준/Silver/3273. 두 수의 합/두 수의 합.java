import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());   // 수열의 크기 n

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());  // 수열 배열 arr
        }

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());   // 두 수의 합 x

        Arrays.sort(arr);   // arr 정렬

        int start = 0;
        int end = n-1;
        int sum = 1;
        int count = 0;

        while(start != end){
            sum = arr[start] + arr[end];
            if(sum < x){
                start++;
            }
            else if(sum > x){
                end--;
            }
            else{
                count++;
                start++;
            }

        }
        System.out.println(count);

    }
}
