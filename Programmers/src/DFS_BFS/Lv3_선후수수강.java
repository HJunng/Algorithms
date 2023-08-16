package DFS_BFS;

import java.util.*;
public class Lv3_선후수수강 {
	static Map<String,ArrayList<String>> subject;
	static Map<String,ArrayList<String>> befSubject;
    static ArrayList<String> answerList = new ArrayList<>();//정답배열
    static Map<String,Boolean> visited;//후수 과목을 다 방문했는지 확인
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new String[] {"A","E","B","D","B","H","F","H","C"}, 
				new String[] {"G","C","G","F","J","E","B","F","B"},"B");
	}
	static public String[] solution(String[] s1, String[] s2, String k) {
        String[] answer = {};

        subject= new HashMap<>();//후수과목_선수과목
        befSubject = new HashMap<>();//선수과목_후수과목
        visited = new HashMap<>();//후수과목 먼저 다 방문했는지

        for(int i=0;i<s2.length;i++) {
        	subject.put(s2[i],new ArrayList<>());
        	befSubject.put(s1[i], new ArrayList<>());
        }

        for(int i=0;i<s1.length;i++) {
        	subject.get(s2[i]).add(s1[i]);//선수과목 저장
        	befSubject.get(s1[i]).add(s2[i]);
        	visited.put(s1[i], false);
        }

        //후수과목부터 선수과목 순으로 올라가면서 저장할 것이므로
        //내림차순 정렬
        for(String s : subject.keySet()) Collections.sort(subject.get(s),Collections.reverseOrder());

        bfs(k);
        System.out.println(answerList);

        return answer;
    }
    static void bfs(String start){
        PriorityQueue<String> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(start);
        while(!q.isEmpty()){
            String now = q.poll();
            answerList.add(now);
            visited.put(now,true);

            if(!subject.containsKey(now)) continue;
            for(String s : subject.get(now)){
            	if(AllVisited(s))  q.add(s);
            }
        }
    }
    static boolean AllVisited(String bef) {
    	if(!befSubject.containsKey(bef)) return true;
    	
    	for(String key:befSubject.get(bef)) {
    		//다 방문하지 않았으면 false
    		if(!visited.get(key)) return false;
    	}
    	return true;
    }
}
