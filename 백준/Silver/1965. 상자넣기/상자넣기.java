import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] box = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            box[i] = Integer.parseInt(s[i]);
        }

        int[] increase = new int[n];
        int maxCnt = 0;
        for(int i=0; i<n; i++){
            increase[i] = 1;
            for(int j=0;j<i;j++){
                if(box[i] > box[j] && increase[i]<increase[j]+1){
                    increase[i] = Math.max(increase[i], increase[j]+1);
                }
            }
            maxCnt = Math.max(maxCnt, increase[i]);
        }
        System.out.println(maxCnt);
    }
}