package Graph;

import java.util.*;
public class Lv3_가장먼노드 {
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>(); //간선 저장
    static int[] visited;
	public static void main(String[] args) {
		
	}
	static public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i=1;i<=n;i++) //간선을 저장할 ArrayList 만들기
            graph.put(i,new ArrayList<Integer>());
        
        for(int i=0;i<edge.length;i++){//간선 저장
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        visited=new int[n+1]; // 1부터 n까지 저장하기 위해 
        
        bfs(1);
        
        int far=0; //가장 멀리 떨어진 노드의 길이
        for(int i=1;i<=n;i++){
            //System.out.println(visited[i]);
            if(visited[i]>far){
                far=visited[i];
                answer=1;
            }else if(visited[i]==far)
                answer++;
        }
        
        return answer;
    }
    static private void bfs(int start){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,1}); //방문하지 않은 노드 값=0과 비교하기 위해 1번 노드 방문순서를 1로 함.
        
         while(!q.isEmpty()){
             int[] now=q.poll();
             
             if(visited[now[0]]!=0) continue; // 방문했던 노드면 넘김.
             
             visited[now[0]]=now[1]; //몇번째로 방문했는지 저장.
             for(int i: graph.get(now[0]))//현재 노드에 연결된 다음 노드 조사.
                 if(visited[i]==0) q.add(new int[]{i,now[1]+1});
             
         }
    }
}
