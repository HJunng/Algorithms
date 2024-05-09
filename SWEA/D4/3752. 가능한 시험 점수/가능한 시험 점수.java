import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){

            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            Map<Integer,Integer> cnt = new HashMap<>();
            s = br.readLine().split(" ");

            for(int i=0;i<n;i++){
                int point = Integer.parseInt(s[i]);
                cnt.put(point, cnt.getOrDefault(point,0)+1);
            }

            set.add(0);
            for(int point : cnt.keySet()){ // O(100)
                List<Integer> setList = new ArrayList<>(set);
                for(int score : setList){ // O(10000)
                    for(int i=cnt.get(point);i>=1;i--){ // O(100)
                        set.add(score+point*i);
                    }
                }
            }

            sb.append("#"+t+" "+set.size()+"\n");
        }
        System.out.println(sb);
    }
}
