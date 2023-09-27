import java.util.*;
class Solution {
    class Task{ // 과제 이름, 남은 시간
        String name;
        int time;
        public Task(String name, int time){
            this.name=name;
            this.time=time;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Map<String, int[]> plan = new HashMap<>();
        for(int i=0;i<plans.length;i++){
            String[] s = plans[i][1].split(":");
            int startTime = Integer.parseInt(s[0])*60+Integer.parseInt(s[1]); //시작시간을 분으로 바꿔줌.
            int play = Integer.parseInt(plans[i][2]);
            
            plan.put(plans[i][0], new int[]{startTime, play});
        }
        
        ArrayList<String> order = new ArrayList<>(plan.keySet());
        Collections.sort(order, (a,b) -> plan.get(a)[0]-plan.get(b)[0]); //시작시간이 짧은 순으로 정렬
        
        
        int cnt=0; //끝낸 과제 개수.
        Stack<Task> save = new Stack<>();
        for(int i=0;i<order.size();i++){
            int nowPlay = plan.get(order.get(i))[1]; //playtime
            int remain = (i!=order.size()-1)? (plan.get(order.get(i+1))[0]-plan.get(order.get(i))[0]):Integer.MAX_VALUE; //현재 과제를 할 수 있는 시간
            
            if(nowPlay<=remain){ //현재 과제를 제한시간 안에 다 끝낼 수 있는 경우.
                
                remain-=nowPlay; //현재 과제를 하고 남은 시간.
                answer[cnt++]=order.get(i); //끝낸 과제 저장
                
                //남은 시간동안 미뤘던 과제 하기.
                while(remain>0){
                    if(save.isEmpty()) break;
                    
                    Task savedTask = save.pop();
                    if(savedTask.time<=remain){
                        remain-=savedTask.time;
                        answer[cnt++]=savedTask.name;
                    }else{
                        savedTask.time-=remain;
                        remain=0;
                        save.push(savedTask);
                    }
                }
                
            }else{ //못 끝내는 경우.
                nowPlay-=remain;
                remain=0;
                save.push(new Task(order.get(i),nowPlay));
            }
        }
        
        // 기존에 미뤘던 과제들 다 하기
        while(!save.isEmpty()){
            answer[cnt++]=save.pop().name;
        }
        
        
        return answer;
    }
}