import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<int[]> reservations = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i=0;i<book_time.length;i++){
            String[] time = book_time[i][0].split(":");
            int startMin = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]); // 대실 시작 시간
            
            time = book_time[i][1].split(":");
            int endMin = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]); // 대실 종료 시간
            
            reservations.add(new int[]{startMin,endMin});
        }
        
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>(); // 방의 이용 가능 시각.
        rooms.add(0); // 일단 방 하나 만듦.
        answer=1;
        
        while(!reservations.isEmpty()){
            
            int[] nowReserve = reservations.poll();
            
            if(nowReserve[0]>=rooms.peek()){ // 이용할 수 있는 룸이 있는 경우: 현재 예약 시작 시간 >= 룸 이용 가능 시각
                
                rooms.poll(); //룸 사용.
                rooms.add(nowReserve[1]+10); // 현재 예약한 객실 이용종료시간 + 10분(청소)
                
            }else{ // 이용할 수 있는 룸이 없는 경우.
                answer++;
                rooms.add(nowReserve[1]+10); // 현재 예약한 객실 이용종료시간 + 10분
            }
        }
        
        return answer;
    }
}