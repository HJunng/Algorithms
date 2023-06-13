package Stack_Queue;

import java.util.*;
public class Lv2_다리를지나가는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] truck_weights = {7,4,5,6};
		//System.out.println(solution(2,10,truck_weights));
		int[] truck_weights2= {10};
		//System.out.println(solution(100,100,truck_weights2));
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		//System.out.println(solution(100,100,truck_weights3));
		int[] truck_weights4 = {2,2,2,2,1,1,1,1,1};
		//System.out.println(solution(5,5,truck_weights4));
		
		//System.out.println(solution(3, 10, new int[] {7,4,5,6}));//11
		//System.out.println(solution(2, 10, new int[] {4,5,4,6}));//6
		//System.out.println(solution(2, 10, new int[] {7,4,5,4,6}));
		//System.out.println(solution(1, 1, new int[] {1,1,1}));
		System.out.println(solution(5,5, new int[] {1,1,1,1,1,2,2,2,2}));
		
		
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> wait = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++)
            wait.add(truck_weights[i]);
        
        Queue<Integer> bridge = new LinkedList<>();
        int now_weight=0;
        int num=0; //다리 끝에 도달한 트럭 개수
        
        while(wait.size()>0 || bridge.size()>0){
            answer++; //걸리는 시간 +1
            
            //기다리는 트럭이 없고, 다리 위에만 트럭이 있을 경우
            if(wait.isEmpty()){
                answer += bridge_length-1;
                break;
            }
            //지금 다리에 트럭을 건너게 할 수 있는 경우
            else if(now_weight+wait.peek()<=weight && bridge.size()+1<=bridge_length){
                now_weight+=wait.peek();
                bridge.add(wait.poll());
            }
            // 다리에 트럭을 더 못올리는 경우
            else{
                if(bridge.size()==bridge_length)
                    num=bridge.size();
                
                //도착한 트럭을 빼야할 때
                if(num!=0){
                    num--;
                    now_weight-=bridge.poll();
                    if(now_weight+wait.peek()<=weight)
                        answer--;
                }
                //트럭을 추가하지 않고, 다리만 건너는 것.
                else{
                    num=bridge.size();
                    answer +=bridge_length-bridge.size()-1;
                }
            }
            System.out.println(bridge+" "+wait+" "+answer+" "+num);
        }
        return answer;
    }
	public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> wait = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++)
            wait.add(truck_weights[i]);
        
        Queue<Integer> bridge = new LinkedList<>();
        int now_weight=0;
        
        System.out.println(bridge+" "+wait+" "+answer);
        
        while(wait.size()>0 || bridge.size()>0){
            answer++; //걸리는 시간
            
            //기다리는 트럭이 더이상 없고, 다리에만 트럭이 있는 경우
            if(wait.isEmpty()) {
            	answer += bridge_length-1;
            	break;
            }
            //wait에 있는 트럭이 다리에 올라갈 수 있는 경우
            else if(now_weight+wait.peek()<=weight && bridge.size()+1<=bridge_length){
                int truck=wait.poll();
                bridge.add(truck);
                now_weight+=truck;
            }
            //wait에 있는 트럭이 다리에 올라갈 수 없는 경우
            else{
                //다리가 꽉찬 경우
                if(bridge.size()==bridge_length){
                    answer += bridge.size()-1;
                    bridge.clear();
                    now_weight=0;
                }
                //다리가 꽉차지 않은 경우
                else{
                    answer += bridge_length-1;
                    bridge.clear();
                    now_weight=0;
                }
                //트럭이 나감과 동시에 들어올 수 있으므로 1초빼줌.
                if(!wait.isEmpty())
                	answer--;
            }
            System.out.println(bridge+" "+wait+" "+answer);
        }
        return answer;
    }
}
