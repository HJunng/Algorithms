package Hash;

import java.util.*;

public class Lv1_달리기경주 {

	public static void main(String[] args) {
		
	}
	public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<Integer,String> rank_name = new HashMap<>();//등수-이름
        HashMap<String,Integer> name_rank = new HashMap<>();//이름-등수
        for(int i=0;i<players.length;i++){
            rank_name.put(i,players[i]);
            name_rank.put(players[i],i);
        }
        for(int i=0;i<callings.length;i++){
            int rank = name_rank.get(callings[i]);//불린 사람이 몇 등인지
            
            
            //등수 바꿔주기.
            rank_name.put(rank,rank_name.get(rank-1));
            name_rank.put(rank_name.get(rank-1),rank);
            name_rank.put(callings[i],rank-1);
            rank_name.put(rank-1,callings[i]);
            
        }
        //0~등부터 answer배열에 넣기
        for(int i=0;i<players.length;i++)
            answer[i]=rank_name.get(i);
        
        return answer;
    }
}
