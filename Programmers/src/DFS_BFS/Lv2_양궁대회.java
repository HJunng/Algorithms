package DFS_BFS;

import java.util.*;
public class Lv2_양궁대회 {
	static ArrayList<Integer> scoreList = new ArrayList<>();
    static int maxSubt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solution(5,new int[] {2,1,1,1,0,0,0,0,0,0,0});

	}
	static public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        dfs(0,0,0,new ArrayList<Integer>(),n,info);
        
        if(scoreList.isEmpty()) return new int[]{-1};
        
        answer = new int[11];
        for(int i=0;i<11;i++) answer[i]=scoreList.get(i);
        
        return answer;
    }
    static void dfs(int idx, int apeach, int lion, ArrayList<Integer> score, int n, int[] info){
        if(idx==info.length){ //끝까지 탐색했을 때
            if(apeach<lion && lion-apeach>maxSubt){ //가장 큰 점수차보다 크면
                scoreList = new ArrayList<>(score);
                maxSubt=lion-apeach;
            }else if(apeach<lion && lion-apeach==maxSubt){//가장 큰 점수차의 경우가 여러 개일때
                
                for(int i=idx-1;i>=0;i--){//가장 작은 점수를 더 많이 맞힌 경우 return
                    if(score.get(i)>scoreList.get(i)){
                        scoreList = new ArrayList<>(score);
                        break;
                    }else if(score.get(i)<scoreList.get(i)) break;
                }
            }
            return;
        }
        
        if(idx==info.length-1){
            score.add(n);
            dfs(idx+1,apeach,lion,score,0,info);
            score.remove(score.size()-1);
            return;
        }
        
        if(n>info[idx]){
            score.add(info[idx]+1);
            dfs(idx+1,apeach,lion+(10-idx),score,n-info[idx]-1,info);
            score.remove(score.size()-1);
        }

        score.add(0);
        if(info[idx]==0) dfs(idx+1,apeach,lion,score,n,info);
        else dfs(idx+1,apeach+(10-idx),lion,score,n,info);
        score.remove(score.size()-1);
        
    }
}
