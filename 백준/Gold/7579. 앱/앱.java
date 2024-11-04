import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class Process{
        int memory,extraFee;
        Process(int memory, int extraFee) {
            this.memory = memory;
            this.extraFee = extraFee;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 앱 개수
        int m = Integer.parseInt(s[1]); // 확보해야 하는 메모리 수

        int[] activate = new int[n]; // 현재 활성화된 메모리
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            activate[i] = Integer.parseInt(s[i]);
        }

        int[] extra = new int[n]; // 비활성화 -> 다시 활성화 시킬 때 발생 비용
        int maxCost = 0;
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            extra[i] = Integer.parseInt(s[i]);
            maxCost += extra[i];
        }

        List<Process> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Process(activate[i], extra[i]));
        }

        Collections.sort(list, new Comparator<Process>(){
            public int compare(Process p1, Process p2){
                if(p1.extraFee != p2.extraFee) return Integer.compare(p1.extraFee, p2.extraFee);
                else return Integer.compare(p2.memory, p1.memory);

//                if(p1.memory!=p2.memory) return p1.memory-p2.memory;
//                else return p2.extraFee - p1.extraFee;
            }
        });

        // activate는 큰데, extra는 작은 거 선택해서 m을 만들어야 함.

        int[][] maxProcess = new int[n+1][maxCost+1];
        int minCost = maxCost;
        for(int i=1;i<=n;i++){ // i번째 process까지 고려함.
            Process now = list.get(i-1);
            for(int j=0;j<=maxCost;j++){

                // 이전값
                int a = maxProcess[i-1][j];
                int b = (j==0 && list.get(i-1).extraFee==0)? list.get(i-1).memory : (j==0)? 0 : maxProcess[i][j-1];
                maxProcess[i][j] = Math.max(a,b);

                // i번째 프로세스를 종료 시킬 때가 더 크면.
                if(j>=now.extraFee && maxProcess[i-1][j-now.extraFee] + now.memory > maxProcess[i][j]){
                    maxProcess[i][j] =  maxProcess[i-1][j-now.extraFee] + now.memory;
                }

                if(maxProcess[i][j]>=m) {
                    minCost = Math.min(minCost, j);
                }
            }
        }

        System.out.println(minCost);
    }
}