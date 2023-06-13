package Hash;


import java.util.*;
public class Lv3_베스트앨범 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String,Integer> genres_count = new HashMap<>();
        HashMap<Integer,Integer> index_plays = new HashMap<>();
        
        // 장르별 재생 횟수.
        for(int i=0;i<genres.length;i++){
            genres_count.put(genres[i],genres_count.getOrDefault(genres[i],0)+plays[i]);
        }
        //index : plays 로 저장
        for(int i=0;i<genres.length;i++){
            index_plays.put(i,plays[i]);
        }
        
        List<String> genres_list = new ArrayList(genres_count.keySet());
        Collections.sort(genres_list, (o1,o2) -> (genres_count.get(o2).compareTo(genres_count.get(o1))));
        
        List<Integer> index_list = new ArrayList(index_plays.keySet());
        Collections.sort(index_list, (o1,o2) -> (index_plays.get(o2).compareTo(index_plays.get(o1))));
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(String genre : genres_list){
            int count=0;
            for(int num : index_list){
                if(count>=2) break;
                
                if(genre.equals(genres[num])){
                    answerList.add(num);
                    count++;
                }
            }
        }
        
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=answerList.get(i);
        
        return answer;
    }
}
