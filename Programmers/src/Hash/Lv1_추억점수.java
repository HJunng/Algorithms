package Hash;

import java.util.*;
public class Lv1_추억점수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String,Integer> score = new HashMap<>();
        for(int i=0;i<name.length;i++) score.put(name[i],yearning[i]);
        
        for(int i=0;i<photo.length;i++){
            int s=0;
            for(int j=0;j<photo[i].length;j++){
                if(score.containsKey(photo[i][j]))
                    s+=score.get(photo[i][j]);
            }
            answer[i]=s;
        }
        return answer;
    }
}
