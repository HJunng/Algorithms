package Stack_Queue;

import java.util.*;
public class Lv2_프린터 {

	public static void main(String[] args) {
		
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		System.out.println(solution(priorities,location));
	}
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++)
            q.add(priorities[i]);
        
        while(location>=0){ // 요청한 문서가 출력되면 location=-1이 되므로 반복문 종료됨.
            int length = q.size();
            int now = q.poll(); // 가장 앞의 문서
            
            //가장 앞에 있는 문서가 중요도가 제일 높은지 확인.
            for(int i=0;i<length-1;i++){
                int n = q.peek();
                if(n>now){  //뒤에 중요도가 더 높은 문서가 있으면
                    q.add(now);//가장 앞의 문서를 제일 뒤에 넣고
                    location--;
                    
                    location-=temp.size(); 
                    q.addAll(temp); // now뒤 ~ 큰 우선순위 전까지를 q에 다시 넣기.
                    
                    temp.clear();
                    
                    //요청한 문서가 q의 맨 뒤로 넣어질 경우, 실행됨.
                    if(location<0) 
                        location+=length;
                    break;
                }
                temp.add(q.poll());
            }
            //맨 앞의 문서가 중요도가 제일 클 경우.
            if(temp.size() == length-1){
                answer++;
                location--;
                
                q.addAll(temp);
                temp.clear();
            }
        }
        return answer;
    }
}
