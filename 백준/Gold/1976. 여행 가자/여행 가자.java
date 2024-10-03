import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int[] childCnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수

        parent = new int[N];
        childCnt = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        String[] s;
        for(int i=0;i<N;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                if(s[j].equals("1")){ // 연결된 것.
                    union(i,j);
                }
            }
        }
        
        s = br.readLine().split(" ");
        int conn = -1;
        boolean poss = true;

        for(int i=0;i<s.length;i++){
            int city = Integer.parseInt(s[i])-1;
            if(conn==-1 || conn==find(city)){
                conn=parent[city];
            } else {
                poss = false;
                break;
            }
        }

        if(poss) System.out.println("YES");
        else System.out.println("NO");
    }
    static int find(int x){
        if(parent[x]==x) return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(childCnt[a]>=childCnt[b]) {
            parent[b]=a;
            childCnt[a]+=childCnt[b];
        } else {
            parent[a]=b;
            childCnt[b]+=childCnt[a];
        }
    }
}