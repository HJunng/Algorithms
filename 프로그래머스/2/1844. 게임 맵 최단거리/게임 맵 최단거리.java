import java.util.*;

class Solution {
    
    class Point{
        int x;
        int y;
        int dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length-1;
        int m = maps[0].length-1;
        
        if(maps[n][m]==0) return -1;
        
        answer = bfs(0,0,maps,n,m);
        
        return answer;
    }
    int bfs(int x, int y, int[][] maps, int n, int m){
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        maps[0][0] = 2; // 방문 했음을 표시, 최소 거리+1
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,2));
        
        while(!q.isEmpty()){
            
            Point now = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx<=n && ny>=0 && ny<=m && maps[nx][ny]==1 ){
                    maps[nx][ny] = now.dist+1;
                    q.add(new Point(nx,ny,now.dist+1));
                }
            }
        }
        
        if(maps[n][m]==1) return -1;
        else return maps[n][m]-1;
    }
}