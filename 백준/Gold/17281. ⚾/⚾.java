import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] orders;
    static boolean[] visit;
    static int maxTotal;
    static int[][] score;

    static class Base{
        boolean first, second, third;
        private Base(){
        }
        private int Hit(int i){
            switch (i){
                case 1: return Single();
                case 2: return Double();
                case 3: return Triple();
                case 4: return Homerun();
                default: return 0;
            }
        }
        private int Single(){
            int s=0;
            if(third) s++; third=false;
            if(second) third=true; second=false;
            if(first) second=true;
            first=true;
            return s;
        }
        private int Double(){
            int s=0;
            if(third) s++; third=false;
            if(second) s++;
            if(first) third=true; first=false;
            second=true;
            return s;
        }
        private int Triple(){
            int s=0;
            if(third) s++;
            if(second) s++; second=false;
            if(first) s++; first=false;
            third=true;
            return s;
        }
        private int Homerun(){
            int s=1;
            if(third) s++; third=false;
            if(second) s++; second=false;
            if(first) s++; first=false;
            return s;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s;

        score = new int[N][10]; // 각 선수 별 점수 기록
        for(int i=0;i<N;i++){
            s = br.readLine().split(" ");
            for(int j=1;j<=9;j++){
                score[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        orders = new int[10];
        visit = new boolean[10];

        orders[4]=1; // 4번째 타자가 1번째 확정
        visit[1]=true;

        maxTotal = 0;
        dfs(1,10);

        System.out.println(maxTotal);

    }
    static void dfs(int depth, int maxDepth){
        if(depth == maxDepth){
            maxTotal = Math.max(maxTotal, calScore());
            return;
        }
        if(depth==4){
            dfs(depth+1, maxDepth);
        } else {
            for(int i=2;i<10;i++){
                if(!visit[i]){
                    visit[i] = true;
                    orders[depth] = i;
                    dfs(depth+1, maxDepth);
                    orders[depth] = 0;
                    visit[i] = false;
                }
            }
        }
    }
    static int calScore(){
        int total = 0;
        int out;
        int order = 1;
        Base base;

        for(int i=0;i<N;i++){ // 이닝 수만큼 반복
            out=0;
            base = new Base();
            while(out<3){
                // 아웃이라면 ++;
                if(score[i][orders[order]]==0) out++;
                else total += base.Hit(score[i][orders[order]]);
                order++;
                if(order>9) order=1;
            }
        }

        return total;
    }
}