class Solution {
    static boolean[][][] visited;
    public int solution(String dirs) {
        int answer = 0;
        
        visited = new boolean[11][11][4]; // (i,j)에 상하좌우 방향 중에 어디로 도달했는지 확인.
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int x=5,y=5;
        
        for(int i=0;i<dirs.length();i++){
            char dir = dirs.charAt(i);
            
            int nx=x, ny=y, d=0;
            if(dir=='U'){
                nx = x+dx[0];
                ny = y+dy[0];
                d=0;
            } else if(dir=='R'){
                nx = x+dx[1];
                ny = y+dy[1];
                d=1;
            } else if(dir=='D'){
                nx = x+dx[2];
                ny = y+dy[2];
                d=2;
            } else {
                nx = x+dx[3];
                ny = y+dy[3];
                d=3;
            }
            
            if(nx<0 || nx>10 || ny<0 || ny>10) continue;
            if(!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[x][y][(d+2)%4]=true; // 역방향도 방문처리 
                answer++;
            }
            
            x=nx; y=ny;
        }
        
        return answer;
    }
}