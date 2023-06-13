package Greedy;

import java.util.*;

public class Lv1_체육복 {

	public static void main(String[] args) {
		
		System.out.println(solution(5,new int[] {2,4},new int[] {1,3,5}));
		System.out.println(solution(3,new int[] {3},new int[] {1}));
	}
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> reFront = new ArrayList<>();
        for(int i=0;i<reserve.length;i++)
            reFront.add(reserve[i]);
        
        //여벌 체육복을 가져온 학생이 도난당했을 경우, 빌려 줄 수 없으므로 list에서 제거.
        ArrayList<Integer> llost = new ArrayList<>();
        for(int i=0;i<lost.length;i++){
            if(reFront.contains(lost[i]))
                reFront.remove(Integer.valueOf(lost[i]));
            else
                llost.add(lost[i]);
        }
        
        answer = n-llost.size(); // 총 인원 - 잃어버린 사람수
        
        ArrayList<Integer> reBack = reFront;
        
        int front=0;
        for(int i=0;i<llost.size();i++){
            if(reFront.contains(llost.get(i)-1)){
                reFront.remove(Integer.valueOf(llost.get(i)-1));
                front++;
            }else if(reFront.contains(llost.get(i+1))){
                reFront.remove(Integer.valueOf(llost.get(i)+1));
                front++;
            }
        }
        
        int back=0;
        for(int i=0;i<llost.size();i++){
            if(reBack.contains(llost.get(i)+1)){
                reBack.remove(Integer.valueOf(llost.get(i)+1));
                back++;
            }else if(reBack.contains(llost.get(i)-1)){
                reBack.remove(Integer.valueOf(llost.get(i)-1));
                back++;
            }
        }
        
        if(front>back)
            return front+answer;
        else
            return back+answer;
    }
}
