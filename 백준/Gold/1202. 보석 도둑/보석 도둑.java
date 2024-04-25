import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 보석 개수
        int k = Integer.parseInt(s[1]); // 가방 개수

        // 가방에는 어차피 보석 1개밖에 안들어감.

        int[][] jewel = new int[n][2];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            jewel[i][0] = Integer.parseInt(s[0]); // 무게
            jewel[i][1] = Integer.parseInt(s[1]); // 가격
        }

        int[] bag = new int[k];
        for(int i=0;i<k;i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewel, (o1,o2)-> {
            if(o1[0] != o2[0]) return Integer.compare(o1[0],o2[0]);
            else return Integer.compare(o1[1],o2[1]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        int idx = 0;
        long cost = 0;
        for(int i=0;i<k;i++){
            int bagWeight = bag[i];

            while(idx<n && jewel[idx][0] <= bagWeight){
                pq.add(new int[]{jewel[idx][0], jewel[idx][1]});
                idx++;
            }
            
            if(!pq.isEmpty()) cost += pq.poll()[1];
        }

        System.out.println(cost);
    }
}