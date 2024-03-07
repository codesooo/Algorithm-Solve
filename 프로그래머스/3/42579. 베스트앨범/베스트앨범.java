import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Set<String> genresSet = new HashSet<>(Arrays.asList(genres));
        Map<String, Integer> genreNum= new HashMap<>();

        for(String genreName : genresSet){
            int genreCountSum = 0;
            for(int i=0; i<genres.length; i++){
                if(genreName.equals(genres[i])){
                    genreCountSum += plays[i];
                }
            }
            genreNum.put(genreName, genreCountSum);
        }


        List<String> keySet = new ArrayList(genreNum.keySet());
        Collections.sort(keySet, (s1, s2) -> genreNum.get(s2) - (genreNum.get(s1)));



        //int idx = 0;
        for(String s : keySet){
            Map<Integer,Integer> numAndPlay = new HashMap<>();
            for(int j=0; j<genres.length;j++){
                if(s.equals(genres[j])){
                    numAndPlay.put(j,plays[j]);
                }
            }
            List<Integer> numSet = new ArrayList<>(numAndPlay.keySet());
            Collections.sort(numSet, (s1, s2) -> numAndPlay.get(s2) - (numAndPlay.get(s1)));

            if(numSet.size() < 2){
                answer.add(numSet.get(0));
            }
            else{
                for(int i=0; i<2;i++){
                    answer.add(numSet.get(i));
                }
            }

        }

        int[] answerArr = answer.stream()
                 .mapToInt(Integer::intValue)
                .toArray();
        return answerArr;
    }
}