import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = 10;
        int N = 100;

        for (int t = 1; t <= T; t++) {
            br.readLine();

            List<LinkedList<Integer>> line = new ArrayList<>();
            for(int i=0;i<N;i++){
                line.add(new LinkedList<>());
            }

            for(int i=0;i<N;i++){
                s = br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    int mag = Integer.parseInt(s[j]);
                    if(mag==1 && (line.get(j).isEmpty() || line.get(j).peekLast()!=1)){
                        line.get(j).add(1); // 극
                    } else if(mag==2 && (line.get(j).isEmpty() || line.get(j).peekLast()!=2)){
                        line.get(j).add(2);
                    }
                }
            }

            for(int i=0;i<N;i++){
                // N극으로 이동
                while(line.get(i).peekFirst()==2){
                    line.get(i).pollFirst();
                }

                // S극으로 자석 이동
                while(line.get(i).peekLast()==1){
                    line.get(i).pollLast();
                }
            }

            int result = 0;
            for(int i=0;i<N;i++){
                int nCnt = 0;
                int sCnt = 0;
                for(int mag : line.get(i)){
                    if(mag==1) nCnt++;
                    else sCnt++;
                }
                result += Math.min(nCnt,sCnt);
            }
            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
