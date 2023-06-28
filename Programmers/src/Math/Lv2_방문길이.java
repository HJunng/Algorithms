package Math;

public class Lv2_방문길이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(String dirs) {
        int answer = 0;
        
        //- 생각하지 않으려고 사분면 위치를 이동시켜서 (0,0)~(10,10)까지로 범위 변경.
        boolean[][][] wayVisited = new boolean[11][11][4]; // 해당 점의 상하좌우 방문 확인.
        
        int x=5;//처음 위치
        int y=5;
        
        for(int i=0;i<dirs.length();i++){
            int dir=dirs.charAt(i);//방향
            //System.out.print("("+x+","+y+") ->");
            
            if(dir=='U' && y+1<=10){
                if(!wayVisited[x][y][0]){ //윗길 방문 한적 없으면
                    answer++;
                    wayVisited[x][y][0]=true;//(x,y)의 윗길 방문 처리
                    wayVisited[x][y+1][1]=true; //(x,y+1) 아랫길 방문 처리
                }
                y++;
                
            }else if(dir=='D' && y-1>=0){
                if(!wayVisited[x][y][1]){//아랫길 방문 한적 없으면
                    answer++;
                    wayVisited[x][y][1]=true;//(x,y) 아랫길 방문 처리
                    wayVisited[x][y-1][0]=true;//(x,y-1) 윗길 방문 처리
                }
                y--;
                
            }else if(dir=='R' && x+1<=10){
                if(!wayVisited[x][y][2]){//오른쪽길 방문 한적 없으면
                    answer++;
                    wayVisited[x][y][2]=true;//(x,y) 오른쪽 방문 처리
                    wayVisited[x+1][y][3]=true;//(x+1,y) 왼쪽 방문 처리
                }
                x++;
                
            }else if(dir=='L' && x-1>=0){
                if(!wayVisited[x][y][3]){//왼쪽 방문 한적 없으면
                    answer++;
                    wayVisited[x][y][3]=true;//(x,y) 왼쪽 방문 처리
                    wayVisited[x-1][y][2]=true; //(x-1,y) 오른쪽 방문 처리
                }
                x--;
                
            }
            //System.out.println(" ("+x+","+y+") : "+answer);
        }
        
        return answer;
    }
}
