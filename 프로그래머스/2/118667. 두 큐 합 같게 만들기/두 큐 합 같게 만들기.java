import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sumQ1=0; long sumQ2 = 0; // 각 queue의 합
        int size = queue1.length; //queue1, queue2의 길이
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        
        for(int i=0;i<size;i++){
            q1.add(queue1[i]);
            sumQ1+=queue1[i];
            q2.add(queue2[i]);
            sumQ2+=queue2[i];
        }
        
        // 합이 홀수이면 둘로 나눌 수 없음 -> -1 리턴.
        if((sumQ1+sumQ2)%2==1) return -1; 
        
        
        int cnt=0; //움직인 횟수.
        while(sumQ1!=sumQ2){
            if(cnt>size*4) return -1;//q1과 q2가 두번씩 돌아가는 동안 찾지 못하면 못 찾는것.
            
            if(sumQ1<sumQ2){//q1의 원소합이 q2 원소합보다 작으면
                sumQ1+=q2.peek();
                sumQ2-=q2.peek();
                q1.add(q2.poll());//q2에서 q1에 집어넣음
                
            }else{ //q1의 원소합이 half보다 크면
                sumQ1-=q1.peek(); 
                sumQ2+=q1.peek();
                q2.add(q1.poll());//q1에서 원소를 poll해 q2에 넣는다.
            }
            cnt++;//작업 횟수 +1
        }
        
        return cnt;
    }
}