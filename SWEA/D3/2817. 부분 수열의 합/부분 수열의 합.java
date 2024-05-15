import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            int[] num = new int[n];
            Map<Integer, Map<Integer,Integer>> map = new HashMap<>();


            for(int i=0;i<n;i++){
                num[i] = Integer.parseInt(s[i]);
                map.put(i,new HashMap<>());

                if(i==0){
                    map.get(0).put(0,1);
                    map.get(0).put(num[0],1);
                }
                else {
                    for(int bef : map.get(i-1).keySet()){
                        map.get(i).put(bef, map.get(i-1).get(bef));
                    }

                    List<Integer> mapKey = new ArrayList<>(map.get(i).keySet());
                    for(int now : mapKey){
                        map.get(i).put(now+num[i], map.get(i-1).get(now)+map.get(i).getOrDefault(now+num[i],0));
                    }
                }
//                System.out.println(map.get(i));
            }

            int result = map.get(n-1).getOrDefault(k,0);
            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
