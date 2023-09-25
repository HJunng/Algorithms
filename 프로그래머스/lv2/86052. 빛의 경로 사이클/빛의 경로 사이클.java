import java.util.*;
class Solution {
    static boolean[][][] visited;
    static int cnt;
    public int[] solution(String[] grid) {
        int[] answer = {};
        
        visited = new boolean[grid.length][grid[0].length()][4];
        ArrayList<Integer> len = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                for(int dir=0;dir<4;dir++){
                    if(!visited[i][j][dir]){
                        cnt=0;
                        len.add(moveGrid(i,j,dir,grid));   
                    }
                }
            }
        }
        Collections.sort(len);
        answer = new int[len.size()];
        for(int i=0;i<len.size();i++) answer[i]=len.get(i);
        
        return answer;
    }
    int moveGrid(int x, int y, int dir, String[] grid){
        int[] dx = {1,0,-1,0};
        int[] dy={0,-1,0,1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,dir});
        visited[x][y][dir]=true;
        
        while(!q.isEmpty()){
            int now[] = q.poll();
            cnt++;
            
            int nx=0,ny=0,ndir=0;
            if(grid[now[0]].charAt(now[1])=='S'){
                nx=now[0]+dx[now[2]];
                ny=now[1]+dy[now[2]];
                ndir=now[2];
            }else if(grid[now[0]].charAt(now[1])=='L'){
                ndir = (now[2]+3)%4;
                nx=now[0]+dx[ndir];
                ny=now[1]+dy[ndir];
            }else if(grid[now[0]].charAt(now[1])=='R'){
                ndir = (now[2]+1)%4;
                nx=now[0]+dx[ndir];
                ny=now[1]+dy[ndir];
            }
            
            nx =(nx+grid.length)% grid.length;
            ny=(ny+grid[0].length())%grid[0].length();
            
            if(!visited[nx][ny][ndir]){
                q.add(new int[]{nx,ny,ndir});
                visited[nx][ny][ndir]=true;
            }
        }
        return cnt;
    }
}