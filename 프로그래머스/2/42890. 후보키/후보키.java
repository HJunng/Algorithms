import java.util.*;

class Solution {
    public Set<Set<Integer>> candidateKey = new HashSet<>();
    public int solution(String[][] relation) {
        int answer = 0;
        
        dfs(0,relation[0].length, new HashSet<>(), relation);
        
        return candidateKey.size();
    }
    // 속성들로 나올 수 있는 조합
    public void dfs(int depth, int maxDepth, Set<Integer> keys, String[][] relation){
        // 속성들 조합 다했으면 확인.
        if(depth==maxDepth){
            if(isCandidate(keys, relation)){
                // System.out.println(keys);
                candidateKey.add(new HashSet<>(keys));
            } 
            return;
        }
        
        // 현재 depth 선택 안함
        dfs(depth+1,maxDepth, keys, relation);
        
        // 현재 depth 선택
        keys.add(depth);
        dfs(depth+1,maxDepth, keys, relation);
        keys.remove(depth);
    }
    // 조합된 속성들이 후보키인지 확인
    public boolean isCandidate(Set<Integer> keys, String[][] relation){
        // 후보키 속성 개수가 0개이면 키가 될 수 없음.
        if(keys.size()==0) return false;
        
        // 후보키 중에 keys가 포함하는 후보키가 있는지 확인. -> 최소성 확인
        for(Set<Integer> candidate : candidateKey){
            if(keys.containsAll(candidate)) return false;
        }
        
        // 후보키가 될 수 있는지 확인
        Set<String> addAttr = new HashSet<>();
        for(int i=0;i<relation.length;i++){
            String attr = "";
            
            for(int k : keys) attr += relation[i][k]+"/";
            
            if(addAttr.contains(attr)) return false;
            addAttr.add(attr);
        }
        
        return true;
    }
}