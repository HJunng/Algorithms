class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        
        if(n==1) return new int[]{1};
        
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        
        int[][] triangle = new int[n][];
        for(int i=1;i<=n;i++){
            triangle[i-1] = new int[i];
        }
        
        int idx = 1;
        int x=0,y=0,dir=0;
        while(true){
            // 방향 돌아서 왔는데 이미 채워져 있으면, 그냥 다 채워진 것.
            if(triangle[x][y]>0) break;
            
            triangle[x][y]=idx++;
            
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            
            if(nx<0 || ny<0 || nx>=n || ny>=triangle[nx].length
                || triangle[nx][ny]>0){ // 방향 전환
                dir = (dir+1)%3;
                nx = x+dx[dir];
                ny = y+dy[dir];
            }
            
            x = nx; y = ny;
        }
        
        idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}