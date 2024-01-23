class Solution {
    public int[] solution(long n) {
        long num = n;
        int pow = 0;     
        while(n >= 10) {
            n /= 10;
            pow++;
        }
        int[] re_num = new int[pow+1];
        
        int i = 0;
        while(i<=pow){
            long temp = num % 10;
            re_num[i] = (int)temp;
            num /= 10;   
            i++;
        }
        // for (int i=0; i<=n_len; i++){
        //     long temp = num %10;
        //     re_num[i] = (int)temp;
        //     num /= 10;
        // }
        return re_num;
    }
}