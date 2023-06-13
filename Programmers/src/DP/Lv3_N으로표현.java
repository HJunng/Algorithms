package DP;
import java.util.*;
public class Lv3_N으로표현 {
	static Queue<int[]> q = new LinkedList<>();
    static int makeNum;
    static int min=8;
	public static void main(String[] args) {
		
		System.out.println(solution(5,12));
	}
	public static int solution(int N, int number) {
        
        makeNum=number;
        
        //무조건 처음은 +5를 하고 시작.
        bfs(5,1);
        
        return min;
    }
    private static void bfs(int num, int level){
        
        q.add(new int[] {num,level});
        
        while(q.size()>0){
            int[] now = q.poll();
            System.out.println(now[0]+" "+now[1]);
            
            if(now[0]<=0) continue;
            if(now[1]>8) {
            	continue;
            }
            if(now[0]==makeNum){
                min= now[1];
                break;
            }
            //사용횟수 N이하일때만 검사 진행
            if(now[1]+1<=8) {
            	//+N
                q.add(new int[]{now[0]+5,now[1]+1});
                //-N
                q.add(new int[] {now[0]-5,now[1]+1});
                	
                //+1
                q.add(new int[] {now[0]+1,now[1]+2});
                //-1
                q.add(new int[] {now[0]-1,now[1]+2});
                //*10+N
                q.add(new int[]{now[0]*10+5,now[1]+1});
                // /N
                q.add(new int[]{now[0]/5,now[1]+1});
                //*N
                q.add(new int[]{now[0]*5,now[1]+1});
            }
            
        }
    }
}
