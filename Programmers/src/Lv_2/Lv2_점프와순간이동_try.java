package Lv_2;
import java.util.*;
public class Lv2_점프와순간이동_try {
	static int minCost=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n) {
        int ans = 0;

        //ans=bfs(n);
        dfs(n,1,1);
        
        
        return minCost;
    }
    private void dfs(int n, int now, int cost){
        
        if(n==now){
            if(cost<minCost) minCost=cost;
            return;
        }
        if(now*2<=n)
            dfs(n,now*2,cost);
        
        dfs(n,now+1,cost+1);
    }
    static private int bfs(int n){
        
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>(); //도달한 적 없을 경우에만 추가.
        q.add(new int[] {0,0}); //시작
        set.add(0);
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==n) //n에 도달하면
                return now[1];
            
            //1칸 점프
            if(!set.contains(now[0]+1)){
                q.add(new int[] {now[0]+1,now[1]+1}); //1칸 점프
                set.add(now[0]+1);
            }
            //순간이동
            if(!set.contains(now[0]*2)){
                q.add(new int[] {now[0]*2,now[1]});
                set.add(now[0]*2);
            }
            
        }
        return -1;
    }

}
