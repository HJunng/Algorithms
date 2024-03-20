import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] parent;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            String[] s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]); //국가의 수
            int m = Integer.parseInt(s[1]); //비행기 종류

            parent = new int[n+1];
            for(int i=1;i<=n;i++) parent[i] = i;

            int cnt=0; // 비행기 종류의 최소 개수
            for(int i=0;i<m;i++){
                s = br.readLine().split(" ");

                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                int parentA = parent[a];
                int parentB = parent[b];

                // 이미 연결되어 있는 상태라면, 사이클 만들지 말고 다음 비행기로 넘기기.
                if(parentA == parentB)
                    continue;

                int minParent = Math.min(parentA,parentB);
                int maxParent = Math.max(parentA,parentB);

                // 더 적은 수로 부모 바꿔주기
                changeParent(minParent,maxParent,n);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static void changeParent(int min, int max, int n){
        for(int i=1;i<=n;i++){
            if(parent[i]==max) parent[i] = min;
        }
    }
}