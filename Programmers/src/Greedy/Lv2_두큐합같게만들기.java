package Greedy;

import java.util.*;
public class Lv2_두큐합같게만들기 {
	static long sumQ1,sumQ2;
    static int size1,size2;
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[] {101,100},new int[] {102,103});
	}
	static public int solution(int[] queue1, int[] queue2) {
        
        sumQ1=0;sumQ2=0;
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            sumQ1+=queue1[i];
            q2.add(queue2[i]);
            sumQ2+=queue2[i];
        }
        size1=size2=queue1.length; //q1과 q2의 길이
        
        if((sumQ1+sumQ2)%2==1) return -1; //합이 홀수이면 둘로 나눌 수 없음
        
        long half=(sumQ1+sumQ2)/2; //total/2
        
        int cnt=0;
        while(sumQ1!=half){
            if(cnt>(size1+size2)*2) return -1;//q1과 q2가 두번씩 돌아가는 동안 찾지 못하면 못 찾는것.
            
            if(sumQ1<half){//q1의 원소합이 half보다 작으면
                sumQ1+=q2.peek();
                q1.add(q2.poll());//q2에서 q1에 집어넣음
                
            }else{ //q1의 원소합이 half보다 크면
                sumQ1-=q1.peek(); 
                q2.add(q1.poll());//q1에서 원소를 poll해 q2에 넣는다.
            }
            cnt++;//작업 횟수 +1
        }
        
        return cnt;
    }
}
