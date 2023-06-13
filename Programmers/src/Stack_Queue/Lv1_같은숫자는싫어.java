package Stack_Queue;

import java.util.*;

public class Lv1_같은숫자는싫어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> s = new Stack<>();
        for(int i : arr){
            if(s.isEmpty()) //첫번째 수는 비교 필요없이 바로 집어넣어야 함.
                s.add(i);
            
            if(s.peek()==i) // 이전에 넣었던 수와 같으면 넣지 않고 다음 반복문 실행.
                continue;
            
            s.add(i);
        }
        answer = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){ //stack의 성질로 뒤에서부터 빼야함
            answer[i] = s.pop();
        }
        
        return answer;
    }
}
