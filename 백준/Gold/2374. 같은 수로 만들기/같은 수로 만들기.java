import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(!set.contains(num)){
                set.add(num);
                pq.add(num);
            }
            if(list.isEmpty() || list.get(list.size()-1) != num){
                list.add(num);
            }
        }
//        System.out.println(pq);
//        System.out.println(list);

        long result = 0;
        while(pq.size()>1){
            int num = pq.poll();

            for(int i=0;i<list.size();i++){
                if(list.get(i)==num){
                    int left = (i>0)?list.get(i-1):Integer.MAX_VALUE;
                    int right = (i<list.size()-1)?list.get(i+1):Integer.MAX_VALUE;

                    // 3 1 3 이런식으로 왼쪽 오른쪽이 같으면 2개 없애야 함.
                    if(left==right){
                        result += left-num;
                        list.remove(i);
                        list.remove(i);
                        i--;
                        continue;
                    }

                    left = Math.min(left,right);
                    result += left-num;
                    list.remove(i);
                    i--;
                }
            }
        }
        System.out.println(result);
    }
}