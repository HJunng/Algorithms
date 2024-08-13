import java.util.*;

class Solution {
    final int MAX = 100001;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 연결할 다리 리스트 생성
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        
        // 연결된 다리 추가하기
        for(int[] i : roads){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        
        // 다익스트라 : destination에서 출발해서 각 지점까지 가장 빠른 cost로 도달할 수 있도록 만들기
        int[] cost = new int[n+1];
        Arrays.fill(cost, MAX);
        
        cost[destination] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        
        boolean[] visit = new boolean[n+1];
        visit[destination]=true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : map.get(now)) {
                // 이전에 방문했으면 최소 cost가 아니므로 다시 방문 x.
                if(!visit[next] && cost[now]+1 < cost[next]){
                    q.add(next);
                    visit[next] = true;
                    cost[next] = cost[now]+1;
                }
            }
        }
        
        for(int i=0;i<sources.length;i++){
            answer[i] = (cost[sources[i]]==MAX)? -1 : cost[sources[i]];
        }
        
        return answer;
    }
}