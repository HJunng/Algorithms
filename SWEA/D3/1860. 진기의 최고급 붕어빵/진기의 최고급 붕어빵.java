import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]); // 자격을 얻은 n명
            int m = Integer.parseInt(s[1]); // m초 동안
            int k = Integer.parseInt(s[2]); // 붕어빵 k개

            s = br.readLine().split(" ");
            List<Integer> people = new ArrayList<>();
            for(int i=0;i<n;i++){
                people.add(Integer.parseInt(s[i]));
            }
            Collections.sort(people);

            int cnt=0;
            int idx=0;
            boolean flag = true;
            for(int i=0;i<=11111;i++){
                if(i!=0 && i%m==0){
                    cnt +=k;
                }
                if(idx==n) break;
                else if(i==people.get(idx)){
                   if(cnt>0){
                       cnt--;
                       idx++;
                   }
                   else{
                       flag = false;
                       break;
                   }
                }
            }
            if(flag){
                sb.append("#"+t+" Possible"+"\n");
            } else{
                sb.append("#"+t+" Impossible"+"\n");
            }

        }
        System.out.println(sb);
    }
}
