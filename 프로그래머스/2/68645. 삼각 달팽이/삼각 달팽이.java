class Solution {
    public int[] dx = {1,0,-1};
    public int[] dy = {0,1,-1};
    
    public int[] solution(int n) {
        int fac = factorial(n);
        
        int[][] arr = new int[n][n];
        
        int x,y,dir;
        x = y = dir = 0;
        for(int i=1;i<=fac;i++){
            
            // 현재 칸에 숫자 채워넣기.
            arr[x][y] = i;
            
            // 다음 칸으로 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 방향 전환이 필요한 경우
            // 1. arr 범위를 벗어날 경우
            // 2. 다음 칸이 채워져있을 경우
            if(nx>=n || ny>=n || arr[nx][ny]>0){
                dir = (dir+1)%3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx; y = ny;
        }
        
        int[] answer = new int[fac];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) continue;
                
                answer[cnt++] = arr[i][j];
            }
        }
        
        
        return answer;
    }
    public int factorial(int n){
        if(n==1) return 1;
        else return n+factorial(n-1);
    }
}