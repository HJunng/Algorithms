package Stack_Queue;

import java.util.*;

public class Lv2_기능개발 {

	public static void main(String[] args) {
		
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
	}
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> p = new LinkedList<>(); // progresses
        Queue<Integer> s = new LinkedList<>(); //speeds
        
        for(int i=0;i<speeds.length;i++){
            p.add(progresses[i]);
            s.add(speeds[i]);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        
       while(!p.isEmpty()){
            if(p.peek()>=100){
                int count=0;
                
                while(!p.isEmpty() && p.peek()>=100){
                    p.poll();
                    s.poll();
                    count++;
                }
                answerList.add(count);
            }
            
            for(int i=0;i<p.size();i++){
                p.add(p.poll()+s.peek());
                s.add(s.poll());
            }
        }
        answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++)
            answer[i] = answerList.get(i);
        
        return answer;
    }
}
