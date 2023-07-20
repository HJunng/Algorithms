package DFS_BFS;

import java.util.*;

public class Lv2_배달 {
	static Map<Integer,ArrayList<int[]>> map = new HashMap<>();//전체 맵
    static Map<Integer,Integer> canGo = new HashMap<>();//visited,걸린시간
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int N, int[][] road, int K) {
        int answer = 0;

        for(int i=1;i<=N;i++) map.put(i,new ArrayList<>());
        
        for(int i=0;i<road.length;i++){
            map.get(road[i][0]).add(new int[]{road[i][1],road[i][2]});//연결도로 + 걸리는 시간 저장
            map.get(road[i][1]).add(new int[]{road[i][0],road[i][2]});
        }
        dfs(1,0,K);

        return canGo.size();
    }
    static void dfs(int now, int time, int maxTime){
        //System.out.println(now);
        canGo.put(now,time);
        
        for(int[] r : map.get(now)){
            //시간이 K를 넘지 않고, 이전에 방문한적이 없거나 방문한 적이 있으면 그때 시간보다 짧을 때 다시 방문
            if(time+r[1]<=maxTime && (!canGo.containsKey(r[0]) || time+r[1]<canGo.get(r[0])))
                dfs(r[0],time+r[1],maxTime);
        }
    }
}
