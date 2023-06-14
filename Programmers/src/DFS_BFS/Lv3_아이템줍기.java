package DFS_BFS;

public class Lv3_아이템줍기 {
	static int[][] way = new int[51][51]; //좌표 값은 1이하 50이하
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] goal = new int[2];
    static boolean[][] visited; //방문했는지
    static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8));
		

	}
	static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        goal[0]=itemX*2;
        goal[1]=itemY*2;
        
        setWay(rectangle); //다각형 둘레 표시.
        //모든 크기의 두배
        characterX*=2;
        characterY*=2;
        
        for(int i=0;i<4;i++){
            if(way[characterX+dx[i]][characterY+dy[i]]==1){
                visited = new boolean[102][102];
                
                visited[characterX][characterY]=true;
                dfs(characterX+dx[i],characterY+dy[i],1); //이동과 동시에 dfs시작.
            }
        }
        
        return min/2;
    }
    static private void dfs(int nowX, int nowY, int idx){
        //System.out.println("("+nowX+","+nowY+") "+idx);
        
        if(nowX==goal[0] && nowY==goal[1]){
            if(idx<min) min=idx;
            return;
        }
        //상하좌우에서 갈 수 있는 곳으로 가기.
        for(int i=0;i<4;i++){
            int newX = nowX+dx[i];
            int newY = nowY+dy[i];
            
            if(way[newX][newY]==1 && !visited[newX][newY]){
                
                visited[newX][newY]=true;
                dfs(newX,newY,idx+1);
                visited[newX][newY]=false;
            }
        }
    }
    //큰 둘레:1, 사각형 내부:2
    static private void setWay(int[][] rect){
        
        for(int i=0;i<rect.length;i++){
            for(int a=rect[i][0]*2;a<=rect[i][2]*2;a++){
                for(int b=rect[i][1]*2;b<=rect[i][3]*2;b++){
                    //오직 둘레(굵은 선)만 1.
                    if(a==rect[i][0]*2 || a==rect[i][2]*2 || b==rect[i][1]*2 || b==rect[i][3]*2){
                        if(way[a][b]==2) continue;
                        way[a][b]=1;
                    }//둘레가 아닌 부분은 2로 처리
                    else
                        way[a][b]=2;
                }
            }
        }
    }
}
