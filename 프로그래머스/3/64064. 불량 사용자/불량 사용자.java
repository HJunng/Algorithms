import java.util.*;
class Solution {
    public Set<Set<String>> answer = new HashSet(); // 제재 아이디 목록 set
    public boolean[] visited; // 방문처리
    
    public int solution(String[] user_id, String[] banned_id) {
        
        visited = new boolean[user_id.length];
        
        dfs(0,banned_id.length, new HashSet<>(), user_id, banned_id);
        
        return answer.size();
        
    }
    
    
    void dfs(int depth, int maxDepth, Set<String> set, String[] user_id, String[] banned_id){
        if(depth==maxDepth){
            if(set.size()==maxDepth) answer.add(new HashSet<>(set));
            return;
        }
        
        for(int i=0;i<user_id.length;i++){
            if(!visited[i] && mapping(user_id[i], banned_id[depth])){
                set.add(user_id[i]);
                visited[i]=true;
                
                dfs(depth+1, maxDepth, set, user_id, banned_id);
                
                visited[i]=false;
                set.remove(user_id[i]);
            }
        }
    }
    // user_id랑 ban_id랑 매핑되는지 확인
    boolean mapping(String user, String ban){
        // 글자수 안맞으면 바로 탈락.
        if(user.length() != ban.length()) return false;
        
        for(int i=0;i<user.length();i++){
            if(ban.charAt(i)=='*' || user.charAt(i)==ban.charAt(i)) continue;
            else return false;
        }
        
        return true;
    }
}