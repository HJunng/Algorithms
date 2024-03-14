import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        LinkedList<Integer> sortedPeople = new LinkedList<>();
        for(int i=0;i<people.length;i++) sortedPeople.add(people[i]);
        
        // 내림차순 정렬
        Collections.sort(sortedPeople, Collections.reverseOrder());
        
        System.out.println(sortedPeople.peekFirst());
        
        while(!sortedPeople.isEmpty()){
            int fir = sortedPeople.peekFirst();
            int lst = sortedPeople.peekLast();
            
            if(fir+lst <= limit){
                sortedPeople.pollFirst();
                sortedPeople.pollLast();
            }else{ //구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없다.
                sortedPeople.pollFirst();
            }
            answer++;
        }
        
        
        return answer;
    }
}