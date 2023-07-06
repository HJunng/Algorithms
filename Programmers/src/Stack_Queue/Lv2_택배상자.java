package Stack_Queue;

import java.util.*;
public class Lv2_택배상자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int orderIdx=0;//몇 번째 박스까지 실었는지
        
        for(int i=1;i<=order.length;i++){
            
            //컨테이너 벨트위의 박스와 order박스가 같은지
            if(i==order[orderIdx]){
                answer++;
                orderIdx++;
            }else{//다르면
                stack.push(i);
            }
            
            //스택에서 마지막 박스와 order박스가 같은지
            while(!stack.isEmpty() && stack.peek()==order[orderIdx]){
                orderIdx++;
                answer++;
                stack.pop();
            }
        }
        
        return answer;
    }
}
