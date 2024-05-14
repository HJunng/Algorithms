import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Integer,Integer> month = new HashMap<Integer,Integer>(){{
        put(1,31); put(2,28); put(3,31); put(4,30); put(5,31); put(6,30);
        put(7,31); put(8,31); put(9,30); put(10,31); put(11,30); put(12,31);
    }};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            s = br.readLine().split(" ");

            int startMonth = Integer.parseInt(s[0]);
            int startDay = Integer.parseInt(s[1]);
            int endMonth = Integer.parseInt(s[2]);
            int endDay = Integer.parseInt(s[3]);

            int result;
            if(startMonth==endMonth){ // 같은 달인 경우
                result = endDay-startDay+1;
                sb.append("#"+t+" "+result+"\n");
            } else { // 다른 달
                result = month.get(startMonth) - startDay +1;
                for(int i=startMonth+1;i<endMonth;i++){
                    result += month.get(i);
                }
                result += endDay;

                sb.append("#"+t+" "+result+"\n");
            }
        }
        System.out.println(sb);
    }
}
