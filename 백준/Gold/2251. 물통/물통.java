import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int[] full = new int[]{a,b,c};

        Set<String> set = new HashSet<>();
        set.add("0 0 "+c);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,c});

        Set<Integer> possibleC = new TreeSet<>();

        while(!q.isEmpty()){
            int[] n = q.poll();

            // a가 비어있으면 c안에 담겨있는 물의 양 저장 해두기.(c에 있을 수 있는 모든 경우)
            if(n[0]==0) possibleC.add(n[2]);

            for(int i=0;i<3;i++){ // 부을 거
                for(int j=0;j<3;j++){ // 넣어지는 거
                    // 나 자신한테 넣거나 부을 거에 물이 없거나 넣으려는 곳이 꽉차 있으면 pass.
                    if(i==j || n[i]==0 || n[j]==full[j]) continue;

                    int[] newN = new int[]{n[0],n[1],n[2]};

                    // 옮겨지는 양
                    int move = Math.min(n[i], full[j]-n[j]);
                    newN[i]-=move;
                    newN[j]+=move;

                    // 기존에 계산 했던 값인 경우
                    if(set.contains(newN[0]+" "+newN[1]+" "+newN[2])) continue;

                    q.add(new int[]{newN[0],newN[1],newN[2]});
                    set.add(newN[0]+" "+newN[1]+" "+newN[2]);
                }
            }
        }
        
        for(int i : possibleC){
            System.out.print(i+" ");
        }
    }
}