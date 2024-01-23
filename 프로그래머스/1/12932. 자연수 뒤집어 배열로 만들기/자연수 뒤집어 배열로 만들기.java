class Solution {
    public int[] solution(long n) {
        long n1 = n;
    int pow = 0;     
    while(n >= 10) {
    	n /= 10;
    	pow++;
    }
    int[] answer = new int[pow+1];
    
    for(int i=0; i<=pow; i++){
    	long nam = n1 % 10;
        answer[i] = (int)nam;
        n1 /= 10;
    }
    
    return answer;
    }
}