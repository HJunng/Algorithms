import java.util.*;

class Solution {
    public Map<String,Integer> newCourse = new HashMap<>(); // 새로 추가하게 될 코스 요리 - 개수 (2개 미만이면 나중에 뺄것.) 
    public boolean[] visited;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0;i<orders.length;i++){
            String order = sortAlpha(orders[i]);
            for(int j=0;j<course.length;j++){
                if(order.length()>=course[j]){
                    visited = new boolean[order.length()];
                    dfs(0,course[j],"", order);
                }
            }
        }
        System.out.println(newCourse);
        
        // 구한 조합들 중에서 길이 별 가장 많이 주문된 코스 횟수 구하기
        Map<Integer,Integer> len_maxOrders = new HashMap<>();
        for(String key : newCourse.keySet()){
            int len = key.length();
            int befMax = len_maxOrders.getOrDefault(len,0);
            len_maxOrders.put(len, Math.max(befMax,newCourse.get(key)));
        }
        
        // 가장 많이 주문된 코스들만 뽑아서 answerList에 넣기.
        List<String> answerList = new ArrayList<>();
        for(String key : newCourse.keySet()){
            int len = key.length();
            if(len_maxOrders.get(len)>1 && newCourse.get(key)==len_maxOrders.get(len)){
                answerList.add(key);
            }
        }
        
        Collections.sort(answerList);
        
        return answerList.stream().toArray(size -> new String[size]);
    }
    void dfs(int idx, int length, String make, String order){
        if(make.length()==length){
            newCourse.put(make, newCourse.getOrDefault(make,0)+1);
            return;
        }
        
        for(int i=idx;i<order.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i,length,make+order.charAt(i),order);
                visited[i]=false;
            }
        }
    }
    String sortAlpha(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}