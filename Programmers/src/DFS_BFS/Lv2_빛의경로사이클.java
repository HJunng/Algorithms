package DFS_BFS;

import java.util.*;
public class Lv2_빛의경로사이클 {
	static int[] dx = {0,1,0,-1}; //위,오른,아래,왼
    static int[] dy = {1,0,-1,0};
    static Set<Integer> startDir = new HashSet<>(); //0행 0열의 방향
    static int endDir;
    static ArrayList<Integer> answerList = new ArrayList<>(); //정답 길이
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new String[] {"SL","LR"});
	}
	static public int[] solution(String[] grid) {
        int[] answer = {};
        
        for(int i=0;i<4;i++){ // i=방향, 상우하좌 순으로 방문
            if(!startDir.contains(i)){ //사이클을 한 번만 표시하기 위해.
                endDir=i;
                dfs(grid,0,0,i,0);
                System.out.println();
            }
        }
        System.out.println(answerList);
        
        return answer;
    }
	static private void dfs(String[] grid, int x, int y, int dir, int idx){
        System.out.print(grid[x].charAt(y));
        
        //사이클이 끝나면 길이 answer에 넣고 반환.
        if(idx!=0 && x==0 && y==0 && dir==endDir){
            answerList.add(idx);
            return;
        }
        //0행 0열 격자에서 나가는 방향 저장.
        if(x==0 && y==0)
            startDir.add(dir);
        
        int nextX,nextY;
        if(grid[x].charAt(y)=='S'){//직진
            //dfs(grid,(x+dx[dir])%,y+dy[dir],dir,idx+1);
        }
        else if(grid[x].charAt(y)=='L'){//왼쪽 회전
            dir = (dir+3)%4;
            //dfs(grid,x+dx[dir],y+dy[dir],dir,idx+1);
        }
        else if(grid[x].charAt(y)=='R'){//오른쪽 회전
            dir = (dir+1)%4;
            //dfs(grid,x+dx[dir],y+dy[dir],dir,idx+1);
        }
        nextX = x+dx[dir];
        nextY = y+dy[dir];
        
        if(nextX<0)
            nextX+=grid.length;
        if(nextX>=grid.length)
            nextX-=grid.length;
        if(nextY<0)
            nextY+=grid[0].length();
        if(nextY>=grid[0].length())
            nextY-=grid[0].length();
        
        dfs(grid,nextX,nextY,dir,idx+1);
    }
}
