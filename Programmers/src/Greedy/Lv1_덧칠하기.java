package Greedy;

public class Lv1_덧칠하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n, int m, int[] section) {
        
        int answer = 0;//페인트 칠해야 하는 횟수
        int now=0;//현재까지 칠해진 위치
        
        for(int i=0;i<section.length;i++){
            if(section[i]>now){
                answer++;
                now=section[i]+m-1;//다시 칠해야 하는 부분부터 m칸 칠하기.
            }
        }
        
        return answer;
    }
}
