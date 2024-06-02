import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        
        //기본적으로 들어온 입력중에 소요시간이 짧은거 먼저 실행하고, 같으면 먼저 들어온거부터 실행
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        
        int now=0;  //현재 시각(초)
        int inputCount=0;//q에 들어간 작업 개수
        int outputCount=0; //최종으로 작업종료된 작업수
        
        
        //모든 입출력이 끝날때까지 반복.
        while(outputCount < jobs.length){
            //입력을 할 수 있으면 하기.
            
            while(inputCount<jobs.length && jobs[inputCount][0]<=now){
                q.add(jobs[inputCount++]);
            }
            
            if(q.isEmpty()){
                now=jobs[inputCount][0];
            }else{
                int[] temp = q.poll();
                System.out.println(temp[0]+" "+temp[1]);
                answer+=temp[1]+now-temp[0];
                now+=temp[1]; //지금 시각에 소요시간 더해주기.
                outputCount++;
            }
            System.out.println(answer);
        }
        return answer/jobs.length;
    }
}