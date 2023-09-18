package DFS_BFS;

import java.util.*;

public class LV2_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];
        
        ArrayList<Integer> area = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]>0){
                    area.add(bfs(i,j,m,n,picture));
                }
            }
        }
        Collections.sort(area, Collections.reverseOrder());
        
        answer[0] = area.size();
        answer[1] = area.get(0);
        
        return answer;
    }
    int bfs(int startX, int startY, int m, int n, int[][] pic){
        
        int cntArea=0;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX,startY});
        int color=pic[startX][startY]; //(startX,startY)의 색깔 저장.
        pic[startX][startY]=-1; //방문처리 해줍니다. -> 다시 방문하지 않도록
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            cntArea++;
            
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx>=0 && nx<m && ny>=0 && ny<n && pic[nx][ny]==color){
                    pic[nx][ny]=-1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        return cntArea;
    }
}
