package Hash;

import java.util.*;
public class Lv2_후보키 {
	static boolean[] visited;//해당 속성 방문 확인
    static ArrayList<HashSet<Integer>> cdk = new ArrayList<>(); //후보키<속성들>
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String[][] relation) {
        int answer = 0;
        
        visited = new boolean[relation[0].length];
        
        //유일성을 갖춘 키
        dfsCandidateKey(new ArrayList<Integer>(),relation[0].length,relation);
        
        Collections.sort(cdk, (a,b)->a.size()-b.size());
        
        answer = cntMinimal(cdk);
        
        return answer;
    }
    //후보키를 만들 수 있는 경우의수
    void dfsCandidateKey(ArrayList<Integer> keys, int len, String[][] rel){
        
        //키 개수가 1개 이상이고, 유일성을 만족한다면 예비 후보키 리스트 cdk에 넣어줌.
        if(keys.size()>0 && isUnique(keys,rel)){
            cdk.add(new HashSet<>(keys));
        }
        
        //이전에 저장한 속성보다 이전의 속성은 dfs로 방문 안함 -> 213 123은 같은 후보키
        int start=keys.size()>0?keys.get(keys.size()-1):0;
        
        for(int i=start;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                keys.add(i);
                
                dfsCandidateKey(keys,len,rel);//후보키 더 조사하기
                
                //원상복귀
                keys.remove(keys.size()-1);
                visited[i]=false;
            }
        }
    }
    //keys가 유일성을 만족하는지 확인
    boolean isUnique(ArrayList<Integer> keys, String[][] rel){
        
        Set<String> keyset = new HashSet<>();
        
        for(int i=0;i<rel.length;i++){
            String key="";
            for(int attr : keys){//키에 해당되는 속성
                key+=rel[i][attr]+" ";
            }
            keyset.add(key);
        }
        //System.out.println(keyset.size()+" "+rel.length);
        
        //유일성을 만족하면 true
        if(keyset.size()==rel.length) return true;
        return false;
    }
    //최소성을 만족하는 키 개수 출력
    int cntMinimal(ArrayList<HashSet<Integer>> keys){
        
        ArrayList<HashSet<Integer>> minimal = new ArrayList<>();
        
        for(HashSet<Integer> k : keys){
            boolean isMinimal=true;
            for(HashSet<Integer> m : minimal){
                if(k.containsAll(m)){
                    isMinimal=false;break;
                }
            }
            if(isMinimal) minimal.add(k);
        }
        
        return minimal.size();
    }
}
