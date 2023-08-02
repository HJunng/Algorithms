package DFS_BFS;

import java.util.*;
public class Lv2_미로탈출 {
	static int[][] visited;//방문 확인
    static int n,m;//가로,세로 길이
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new String[] {"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"});
	}
	static public int solution(String[] maps) {
        int answer = 0;
        
        n=maps.length; m=maps[0].length();
        
        
        int sx=0,sy=0;//시작점
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='S'){
                    sx=i;sy=j;
                }
            }
        }
        int[] arrive = bfs(maps,sx,sy,'L');
        if(arrive[0]==-1) return -1;
        
        answer+=arrive[2];
        
        arrive = bfs(maps,arrive[0],arrive[1],'E');
        if(arrive[0]==-1) return -1;
        
        answer+=arrive[2];
        
        return answer;
    }
    static int[] bfs(String[] maps, int sx, int sy, char end){
        
        visited = new int[n][m];
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy]=1;
        
        while(!q.isEmpty()){
            int now[] = q.poll();
            
            if(maps[now[0]].charAt(now[1])==end){
                //도착x, 도착y, 걸린 시간
                return new int[]{now[0],now[1],visited[now[0]][now[1]]-1};
            }
            
            for(int i=0;i<4;i++){//상하좌우
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                //이동한 좌표가
                //maps 범위를 벗어나지 않고, 벽이 아니며, 방문한 적이 없을 때
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length()
                  && maps[nx].charAt(ny)!='X' && visited[nx][ny]==0){
                    visited[nx][ny]=visited[now[0]][now[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return new int[]{-1};
    }
}
