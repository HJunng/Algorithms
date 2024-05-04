import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=10;tc++){
            int dump = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");

            PriorityQueue<Integer> higher = new PriorityQueue<>((a,b)->b-a);
            PriorityQueue<Integer> lower = new PriorityQueue<>();

            for(int i=0;i<100;i++){
                int height = Integer.parseInt(s[i]);
                higher.add(height);
                lower.add(height);
            }

            while(dump-->0){
                if(higher.peek()-lower.peek()<=1) break;

                int max = higher.poll();
                int min = lower.poll();
                lower.remove(max);
                higher.remove(min);

                higher.add(max-1);
                higher.add(min+1);
                lower.add(max-1);
                lower.add(min+1);
            }


            sb.append("#"+tc+" "+(higher.peek()-lower.peek())+"\n");
        }
        System.out.println(sb);
    }
}
