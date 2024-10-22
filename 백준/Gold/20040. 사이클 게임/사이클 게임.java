import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parents;
    static int[] childCnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 점의 개수
        int m = Integer.parseInt(s[1]); // 턴 수

        parents = new int[n];
        childCnt = new int[n];

        // 조상 초기화
        for(int i=0;i<n;i++) parents[i] = i;

        int answer = 0;
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            if(find(a)==find(b)){
                answer = i+1;
                break;
            } else {
                union(a,b);
            }
        }
        System.out.println(answer);
    }
    static int find(int x){
        if(parents[x] == x) return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(childCnt[x] > childCnt[y]){
            parents[y] = x;
            childCnt[x] += childCnt[y];
        } else {
            parents[x] = y;
            childCnt[y] += childCnt[x];
        }
    }
}