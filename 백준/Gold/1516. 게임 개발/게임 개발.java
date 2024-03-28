import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] minTime;
    public static int[] buildTime;
    public static Map<Integer,Set<Integer>> beforeBuild;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        buildTime = new int[n+1];
        minTime = new int[n+1];
        Arrays.fill(minTime,-1); // 아직 최단시간 안구했을 때 -1로 초기화.

        beforeBuild = new HashMap<>();

        for(int i=1;i<=n;i++){
            String[] s = br.readLine().split(" ");
            buildTime[i] = Integer.parseInt(s[0]);

            beforeBuild.put(i,new HashSet<>());
            for(int j=1;j<s.length-1;j++) beforeBuild.get(i).add(Integer.parseInt(s[j]));
        }

        for(int i=1;i<=n;i++){
            System.out.println(findMinTime(i));
        }
    }
    public static int findMinTime(int num){
        if(minTime[num]>0) return minTime[num];

        int max = 0;
        for(int before : beforeBuild.get(num))
            max = Math.max(max, findMinTime(before));

        minTime[num] = buildTime[num] + max;
        return minTime[num];
    }
}