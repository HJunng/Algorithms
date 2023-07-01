package Stack_Queue;

import java.util.*;
public class Lv2_뒤에있는큰수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<numbers.length;i++){
            if(stack.isEmpty()){
                stack.push(new int[]{numbers[i],i});continue;
            }
            while(!stack.isEmpty() && (stack.peek())[0]<numbers[i]){
                answer[(stack.pop())[1]]=numbers[i];
            }
            stack.push(new int[]{numbers[i],i});
        }
        for(int[] i:stack)
            answer[i[1]]=-1;
        
        return answer;
    }
}
