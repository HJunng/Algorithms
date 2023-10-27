import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		
		System.out.println(bfs(x));
	}
	private static int bfs(int x) {
		
		boolean[] visited = new boolean[x+1];
		visited[x]=true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,0});
		
		int minCnt=0;
		while(!q.isEmpty()) {
			 int[] now = q.poll();
			 
			 if(now[0]==1) {
				 minCnt=now[1]; break;
			 }
			 
			 if(now[0]%3==0 && !visited[now[0]/3]) {
				 visited[now[0]/3]=true;
				 q.add(new int[] {now[0]/3,now[1]+1});
			 }
			 if(now[0]%2==0 && !visited[now[0]/2]) {
				 visited[now[0]/2]=true;
				 q.add(new int[] {now[0]/2,now[1]+1});
			 }
			 if(!visited[now[0]-1]) {
				 visited[now[0]-1]=true;
				 q.add(new int[] {now[0]-1,now[1]+1});
			 }
		}
		return minCnt;
	}
}