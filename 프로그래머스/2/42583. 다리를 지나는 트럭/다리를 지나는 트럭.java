import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        // 비어있는 다리의 공간을 0으로 가득 채움.
        for(int i=0;i<bridge_length;i++)
            bridge.add(0);
        
        Queue<Integer> wait = new LinkedList<>();
        
        for(int i=0;i<truck_weights.length;i++)
            wait.add(truck_weights[i]);
        
        int now_weight = 0; //현재 다리에 올라가있는 무게
        
        while(now_weight>0 || wait.size()>0){
            now_weight-=bridge.poll(); //도착한 트럭의 무게 빼줌.
            answer++;
            if(wait.isEmpty()){
                answer+= bridge_length-1;
                break;
            }
            if(now_weight+wait.peek()<=weight){
                now_weight+=wait.peek();
                bridge.add(wait.poll());
            }else{
                //버티지 못한다면 0을 추가한다.
                bridge.add(0);
            }
        }
        
        
        return answer;
    }
}