import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=8;i++)
            list.add(new HashSet<Integer>());
        
        list.get(1).add(N);
        
        if(number==N) return 1;
        
        for(int i=2;i<=8;i++){
            // total = 숫자를 i개 썼을 때 숫자들이 들어갈 통
            HashSet<Integer> total = list.get(i);
            
            for(int j=1;j<i;j++){
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for(int x:a){
                    for(int y:b){
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x!=0 && y!=0) total.add(x/y);
                    }
                }
                // 같은 숫자로 된거 추가
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            
            if(total.contains(number)) return i;
        }
        
        return -1;
    }
}