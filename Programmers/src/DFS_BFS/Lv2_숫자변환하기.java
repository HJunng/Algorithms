package DFS_BFS;

import java.util.*;
public class Lv2_숫자변환하기 {

	static boolean[] visited = new boolean[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int x, int y, int n) {
        
        return bfs(x,y,n);
    }
    //너비 우선 탐색 bfs
    static int bfs(int x, int y, int n){
        
        int cnt=-1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==y){
                cnt = now[1];break;
            }
            
            if(now[0]+n<=y && !visited[now[0]+n]){
                q.add(new int[]{now[0]+n, now[1]+1});
                visited[now[0]+n]=true;
            }
            if(now[0]*2<=y && !visited[now[0]*2]){
                q.add(new int[]{now[0]*2,now[1]+1});
                visited[now[0]*2]=true;
            }
            if(now[0]*3<=y && !visited[now[0]*3]){
                q.add(new int[]{now[0]*3, now[1]+1});
                visited[now[0]*3]=true;
            }
        }
        
        return cnt;
    }
}
