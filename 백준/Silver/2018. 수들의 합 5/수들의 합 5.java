import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int sIndex = 1;
        int eIndex = 1;
        int sum = 1;

        while(sIndex<=N){
            if(sum==N){
                count++;
                eIndex++;
                sum = sum + eIndex;
            }
            else if(sum>N){
                sum = sum - sIndex;
                sIndex++;
            }
            else{
                eIndex++;
                sum = sum + eIndex;
            }
        }
        System.out.println(count);;

    }
}
