import java.util.*;
class Solution {
    static boolean[] useTicket;
    static ArrayList<String> visitOrder = new ArrayList<>(); //방문 순서
    static ArrayList<String> answerList = new ArrayList<>(); //정답 여행 경로
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        useTicket=new boolean[tickets.length];
        
        //알파벳 순서로 정렬.
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    return o1[0].compareTo (o2[0]);
            }
        });
        
        visitOrder.add("ICN"); //처음 시작은 icn
        dfs(tickets,0);
        
        answer = new String[visitOrder.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=answerList.get(i);
        
        return answer;
    }
    private void dfs(String[][] tickets, int idx){ //idx는 사용한 티켓 수.
        
        //System.out.println(visitOrder);
        //모든 티켓을 사용했으면 종료.
        if(idx==useTicket.length){
            answerList=visitOrder;
            return;
        }
        
        String start=visitOrder.get(visitOrder.size()-1); //이전 도착지
        
        for(int i=0;i<tickets.length;i++){
            if(!useTicket[i] && start.equals(tickets[i][0])){
                useTicket[i]=true;
                visitOrder.add(tickets[i][1]); //도착지 입력
                
                dfs(tickets,idx+1);
                //dfs로 탐색을 마치면 더이상 탐색하지 않음.
                if(answerList.size()>0) break;
                
                visitOrder.remove(visitOrder.size()-1);
                useTicket[i]=false;
            }
        }
    }
}