package Graph;

import java.util.*;
public class Lv3_순위 {
	static Map<Integer,ArrayList<Integer>> win = new HashMap<>(); // 내가 이긴 사람
    static Map<Integer,ArrayList<Integer>> lose = new HashMap<>();// 내가 진 사람
    static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static     public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            win.put(i,new ArrayList<>());
            lose.put(i,new ArrayList<>());
        }
        for(int i=0;i<results.length;i++){
            win.get(results[i][0]).add(results[i][1]); //이긴사람의 win list에 진사람 추가
            lose.get(results[i][1]).add(results[i][0]);//진사람 lose list에 이긴사람 추가
        }
        
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i,win); // i가 무조건 이길 수 있는 상대 탐색
            dfs(i,lose); // 무조건 질 상대 탐색
            
            if(AllVisited()) answer++;
        }
        
        return answer;
    }
    //모든 노드를 방문했는지 확인
    static boolean AllVisited(){
        boolean b = true;
        
        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                b=false; break;
            }
        }
        return b;
    }
    //방문할 수 있는 모든 노드 방문.
    static void dfs(int i, Map<Integer,ArrayList<Integer>> DirectedGraph){
        
        visited[i]=true;
        
        for(int j : DirectedGraph.get(i))
            if(!visited[j]) dfs(j, DirectedGraph);
    }
}
