import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(String time : timetable){
            pq.add(timeToMin(time));
        }
        
        int now = 9*60; // 9시
        
        // 마지막-1 버스까지 태우기
        for(int i=0;i<n-1;i++){ // 셔틀 운행 횟수
            for(int j=0;j<m;j++){ // 셔틀에 탈 수 있는 크루 수
                
                // 더이상 태울 사람이 없을 때
                if(pq.isEmpty() || pq.peek()>now) break;
                
                pq.poll(); // 사람 태움
            }
            now += t; // 셔틀 운행 간격
        }
        
        // System.out.println(pq);
        
        // 마지막 버스
        // 마지막 버스 시간보다 전이어야 함.
        // 여러명이 탈 경우 콘은 맨 끝
        
        if(pq.isEmpty()) return minToTime(now);
        
        int corn = pq.peek()-1;
        int total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            if(!pq.isEmpty() && pq.peek()<=now){
                int time = pq.poll();
                total++;
                map.put(time, map.getOrDefault(time,0)+1);
            }
        }
        if(total<m) return minToTime(now); // 다 태웠는데 자리가 남으면 corn은 버스 도착시간에 도착한다.
        
        for(int time : map.keySet()){
            if(map.get(time)<m){
                m -= map.get(time);
                corn = time;
            } else {
                corn = time-1;
            }
        }
        
        return minToTime(corn);
    }
    int timeToMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
    String minToTime(int time){
        String hour = (time/60)<10 ? "0"+time/60 : String.valueOf(time/60);
        String min = (time%60)<10 ? "0"+time%60 : String.valueOf(time%60);
        
        return hour+":"+min;
    }
}