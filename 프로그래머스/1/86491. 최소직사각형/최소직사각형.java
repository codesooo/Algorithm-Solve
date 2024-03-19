class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        
        int max_w=0;
        int max_h=0;
        for(int i=0; i<sizes.length; i++){
            int max_l = Math.max(sizes[i][0],sizes[i][1]);
            int min_l = Math.min(sizes[i][0],sizes[i][1]);
            
            max_w = Math.max(max_w, max_l);
            max_h = Math.max(max_h, min_l);
        }
        
        answer = max_w * max_h;
        return answer;
    }
}