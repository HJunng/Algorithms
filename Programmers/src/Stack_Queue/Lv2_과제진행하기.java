package Stack_Queue;

import java.util.*;
public class Lv2_과제진행하기 {
	class Task{
        String name;
        int startTime;
        int playtime;
        
        public Task(String name, int startTime, int playtime){
            this.name=name;
            this.startTime=startTime;
            this.playtime=playtime;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        ArrayList<Task> order = new ArrayList<>();
        for(int i=0;i<plans.length;i++){
            String[] start=plans[i][1].split(":");
            int starttime=Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            order.add(new Task(plans[i][0],starttime, Integer.parseInt(plans[i][2])));
        }
                      
        Collections.sort(order, (a,b)-> a.startTime-b.startTime);
        
        int time=0;
        int cnt=0;
        Stack<Task> stack = new Stack<>();
        for(int i=0;i<order.size();i++){
            //다음 task 시작 시간 구하기(만약 마지막 task라면 24시라고 둠.)
            int nextStart = i!=order.size()-1?order.get(i+1).startTime:Integer.MAX_VALUE;
            int remain=nextStart-order.get(i).startTime;//이용할 수 있는 시간
            
            //현재 과제를 이용할 수 있는 시간동안 다 끝낼 수 있는 경우
            if(remain>=order.get(i).playtime){
                answer[cnt++]=order.get(i).name;//끝낸 일 적기
                remain-=order.get(i).playtime;//현재 과제 끝내고 남은 시간
            }else{//다 못 끝낼 경우.
                order.get(i).playtime-=remain;//이용할 수 있는 시간만큼 일단 과제하기
                remain=0;
                stack.push(order.get(i));//남은 일 전체 넣기
            }
            
            //남은 시간이 있고, 밀린 과제가 있다면 하기.
            while(remain>0 && !stack.isEmpty()){
                Task catchup = stack.pop();
                
                if(remain>= catchup.playtime){//밀린 일을 끝낼 수 있다면
                    answer[cnt++]=catchup.name;
                    remain-=catchup.playtime;
                }else{
                    catchup.playtime-=remain;
                    remain=0;
                    stack.push(catchup);
                }
            }
        }
        
        return answer;
    }
}
