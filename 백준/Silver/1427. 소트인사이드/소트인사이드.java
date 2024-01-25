import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int temp = N;
        int N_len=0;
        while(temp>0){
            temp /= 10;
            N_len++;
        }
        String[] arr = new String[N_len];
        int num = N;
        for(int i=0; i<N_len; i++){
            int temp2 = num % 10;
            arr[i]=String.valueOf(temp2);
            num = num / 10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(String.join("",arr));
    }
}
