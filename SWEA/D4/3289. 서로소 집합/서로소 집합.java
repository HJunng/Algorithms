import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int[] parent;
    static int[] childCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            parent = new int[n+1];
            childCnt = new int[n+1];

            for(int i=1;i<=n;i++) parent[i] = i;

            for(int i=0;i<m;i++){
                s = br.readLine().split(" ");

                int op = Integer.parseInt(s[0]);
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);

                if(op==0){
                    union(a,b);
                } else { // op==1
                    if(find(a)==find(b)){
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int find(int x){
        if(parent[x]==x) return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(childCnt[a]<=childCnt[b]){
            childCnt[b]+=childCnt[a];
            parent[a] = b;
        } else {
            childCnt[a] += childCnt[b];
            parent[b] = a;
        }
    }
}
